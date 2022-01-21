package leetcode.easy;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric_101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }


    public boolean isSymmetric_Iteration(TreeNode root) {
        Queue<TreeNode> work = new LinkedList<>();
        work.add(root);
        work.add(root);
        while (!work.isEmpty()) {
            TreeNode first = work.poll();
            TreeNode second = work.poll();
            if (first == null && second == null) {
                continue;
            }
            if (first == null || second == null) {
                return false;
            }
            if (first.val != second.val) {
                return false;
            }
            work.add(first.left);
            work.add(second.right);
            work.add(first.right);
            work.add(second.left);
        }
        return true;
    }
}
