package leetcode.middle;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> work = new LinkedList<>();
        work.add(root);
        int leve = 1;
        while (!work.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            List<TreeNode> next = new ArrayList<>();
            while (!work.isEmpty()) {
                TreeNode poll = work.poll();
                item.add(poll.val);
                if (poll.left != null) {
                    next.add(poll.left);
                }
                if (poll.right != null) {
                    next.add(poll.right);
                }
            }
            if (leve % 2 != 0) {
                reverseList(item);
            }
            work.addAll(next);
            res.add(item);
            leve++;
        }
        return res;
    }

    private void reverseList(List<Integer> nums) {
        int n = nums.size();
        for (int i = 0; i < n / 2; i++) {
            Integer temp = nums.get(i);
            nums.set(i, nums.get(n - 1 - i));
            nums.set(n - 1 - i, temp);
        }
    }


}
