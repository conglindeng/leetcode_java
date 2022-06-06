package leetcode.middle;

import struct.TreeNode;

public class DeleteNode_Again_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null) {
                TreeNode right = getRight(root.left);
                root.val = right.val;
                root.left = deleteNode(root.left, root.val);
            } else {
                TreeNode right = getLeft(root.right);
                root.val = right.val;
                root.right = deleteNode(root.right, root.val);
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode getRight(TreeNode left) {
        TreeNode temp = left;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }


    private TreeNode getLeft(TreeNode right) {
        TreeNode temp = right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }
}
