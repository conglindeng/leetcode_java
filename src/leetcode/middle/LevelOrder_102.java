package leetcode.middle;

import struct.TreeNode;

import java.util.*;

public class LevelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> work = new LinkedList<>();
        work.add(root);
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
            res.add(item);
            work.addAll(next);
        }
        return res;
    }
}
