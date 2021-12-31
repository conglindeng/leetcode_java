package leetcode.middle;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class IsEvenOddTree_1609 {
    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        if (root == null) {
            return false;
        }
        Deque<TreeNode> work = new LinkedList<>();
        work.add(root);
        while (!work.isEmpty()) {
            int isEven = level % 2;
            List<TreeNode> nextLevel = new ArrayList<>();
            while (!work.isEmpty()) {
                TreeNode poll = work.poll();
                if (!validateNumAndAdd(poll.left, isEven, nextLevel)) {
                    return false;
                }
                if (!validateNumAndAdd(poll.right, isEven, nextLevel)) {
                    return false;
                }
            }
            work.addAll(nextLevel);
            level++;
        }
        return true;
    }

    private boolean validateNumAndAdd(TreeNode node, int isEven, List<TreeNode> nextLevel) {
        if (node == null) {
            return true;
        }
        //isEven为1的话，说明是奇数列，此时node应该是偶数，且严格递减
        int flag = (node.val % 2) ^ isEven;
        if (flag == 1) {
            return false;
        }
        if (!nextLevel.isEmpty()) {
            TreeNode pre = nextLevel.get(nextLevel.size() - 1);
            nextLevel.add(node);
            return (isEven == 1 && pre.val < node.val) || (isEven == 0 && pre.val > node.val);
        }
        nextLevel.add(node);
        return true;
    }
}
