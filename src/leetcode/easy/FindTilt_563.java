package leetcode.easy;

import struct.TreeNode;

public class FindTilt_563 {
    int res = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftVal = dfs(root.left);
        int rightVal = dfs(root.right);
        res +=  Math.abs(leftVal - rightVal);
        return leftVal + rightVal + root.val;
    }

}
