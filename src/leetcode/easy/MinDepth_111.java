package leetcode.easy;

import struct.TreeNode;

public class MinDepth_111 {
    int res = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getHeight(root, 1);
        return res;
    }

    private void getHeight(TreeNode root, int height) {
        if (root.left == null && root.right == null) {
            res = Math.min(res, height);
        }
        if (root.left != null) {
            getHeight(root.left, height + 1);
        }
        if (root.right != null) {
            getHeight(root.right, height + 1);
        }
    }
}
