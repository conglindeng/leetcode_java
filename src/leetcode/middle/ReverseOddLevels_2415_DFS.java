package leetcode.middle;

import struct.TreeNode;

public class ReverseOddLevels_2415_DFS {

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root.left, root.right, true);
        return root;
    }

    public void dfs(TreeNode left, TreeNode right, boolean odd) {
        if (left == null) {
            return;
        }
        if (odd) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        dfs(left.left, right.right, !odd);
        dfs(left.right, right.left, !odd);
    }

}
