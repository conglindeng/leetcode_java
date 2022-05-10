package leetcode.easy;

import struct.TreeNode;

public class LowestCommonAncestor_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (containNode(root.left, p) && containNode(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (containNode(root.right, p) && containNode(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    private boolean containNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root.equals(node)) {
            return true;
        }
        if (root.val > node.val) {
            return containNode(root.left, node);
        }
        return containNode(root.right, node);
    }


    public TreeNode lowestCommonAncestor_Optimize(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val > p.val && temp.val > q.val) {
                temp = temp.left;
            } else if (temp.val < p.val && temp.val < q.val) {
                temp = temp.right;
            } else {
                return temp;
            }
        }
        return null;
    }
}
