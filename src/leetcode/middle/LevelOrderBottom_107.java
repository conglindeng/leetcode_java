package leetcode.middle;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> work = new LinkedList<>();
        work.add(root);
        while (!work.isEmpty()) {
            List<Integer> nums = new ArrayList<>();
            List<TreeNode> next = new ArrayList<>();
            while (!work.isEmpty()) {
                TreeNode poll = work.poll();
                nums.add(poll.val);
                if (poll.left != null) {
                    next.add(poll.left);
                }
                if (poll.right != null) {
                    next.add(poll.right);
                }
            }
            res.add(nums);
            work.addAll(next);
        }
        int size = res.size();
        for (int i = 0; i < size / 2; i++) {
            List<Integer> temp = res.get(i);
            res.set(i, res.get(size - 1 - i));
            res.set(size - 1 - i, temp);
        }
        return res;
    }
}
