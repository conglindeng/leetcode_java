package leetcode.middle;

import struct.TreeNode;

public class PruneTree_814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null || (root.val == 0 && root.left == null && root.right == null)) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }






}
