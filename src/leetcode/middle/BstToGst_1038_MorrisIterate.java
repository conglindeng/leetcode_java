package leetcode.middle;

import struct.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
public class BstToGst_1038_MorrisIterate {

    public TreeNode bstToGst(TreeNode root) {
        int sum = 0;
        TreeNode temp = root;
        while (temp != null) {
            if (temp.right == null) {
                sum += temp.val;
                temp.val = sum;
                temp = temp.left;
            } else {
                TreeNode left = getLeft(temp);
                if (left.left == null) {
                    left.left = temp;
                    temp = temp.right;
                } else {
                    left.left = null;
                    sum += temp.val;
                    temp.val = sum;
                    temp = temp.left;
                }
            }
        }
        return root;
    }


    public TreeNode getLeft(TreeNode node) {
        TreeNode temp = node.right;
        while (temp.left != null && temp.left != node) {
            temp = temp.left;
        }
        return temp;
    }

}
