package leetcode.easy;

import struct.TreeNode;

public class HasPathSum_112 {
    boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        dfs(root, root.val, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int cur, int target) {
        if (res) {
            return;
        }
        if (root.left == null && root.right == null && target == cur) {
            res = true;
            return;
        }
        if (root.left != null) {
            dfs(root.left, cur + root.left.val, target);
        }
        if (root.right != null) {
            dfs(root.right, cur + root.right.val, target);
        }
    }


    public boolean hasPathSum_Optimize(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum_Optimize(root.left, targetSum - root.val) || hasPathSum_Optimize(root.right, targetSum - root.val);
    }

}
