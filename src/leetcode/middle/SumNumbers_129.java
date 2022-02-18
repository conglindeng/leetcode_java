package leetcode.middle;

import struct.TreeNode;

public class SumNumbers_129 {
    int res = 0;

    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            String s = sb.toString();
            res += Integer.parseInt(s);
            return;
        }
        if (root.left != null) {
            dfs(root.left, sb);
        }
        if (root.right != null) {
            dfs(root.right, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    public int sumNumbers_2(TreeNode root) {
        return dfs_2(root, 0);
    }

    private int dfs_2(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs_2(root.left, sum) + dfs_2(root.right, sum);
        }
    }

}
