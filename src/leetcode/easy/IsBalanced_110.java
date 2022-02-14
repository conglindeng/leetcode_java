package leetcode.easy;


import struct.TreeNode;

public class IsBalanced_110 {
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        getHeight(root, 0);
        return res;
    }

    private int getHeight(TreeNode root, int height) {
        if (root == null || !res) {
            return height;
        }
        int l = getHeight(root.left, height + 1);
        int r = getHeight(root.right, height + 1);
        if (Math.abs(l - r) > 1) {
            res = false;
        }
        return Math.max(l, r);
    }
}
