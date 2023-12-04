package leetcode.middle;

import struct.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
public class BstToGst_1038_MiddleIterate {

    int sum;

    int preSum;

    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        ldr(root);
        System.out.println(sum);
        preSum = 0;
        updateVal(root);
        return root;
    }


    public void ldr(TreeNode node) {
        if (node == null) {
            return;
        }
        ldr(node.left);
        sum += node.val;
        ldr(node.right);
    }

    public void updateVal(TreeNode node) {
        if (node == null) {
            return;
        }
        updateVal(node.left);
        int temp=node.val;
        node.val = sum - preSum;
        preSum =preSum+ temp;
        updateVal(node.right);
    }

}
