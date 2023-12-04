package leetcode.middle;

import struct.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
public class BstToGst_1038_ReverseLDR {

    int sum;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);

            sum += root.val;
            root.val = sum;

            bstToGst(root.left);
        }
        return root;
    }
}
