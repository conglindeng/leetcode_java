package leetcode.difficult;

import struct.TreeNode;

public class MaxPathSum_124 {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        doGetMaxSum(root);
        return res;
    }

    private int doGetMaxSum(TreeNode root) {
        int left = 0;
        if (root.left != null) {
            left = doGetMaxSum(root.left);
        }
        int right = 0;
        if (root.right != null) {
            right = doGetMaxSum(root.right);
        }
        int cur = root.val + Math.max(left, right);
        res = Math.max(res, cur);
        res = Math.max(left + right + root.val, res);
        return Math.max(cur, 0);
    }
}
