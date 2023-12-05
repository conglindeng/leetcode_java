package leetcode.easy;

import struct.TreeNode;

public class IsSubtree_572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null && subRoot == null) {
            return false;
        }
        if (root == null && subRoot != null) {
            return false;
        }
        return isEqual(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isEqual(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null && subRoot == null) {
            return false;
        }
        if (root == null && subRoot != null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
    }
}
