package leetcode.middle;

import struct.TreeNode;

public class DeleteNode_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null) {
                root.val = findLeft(root.left).val;
                root.left = deleteNode(root.left, root.val);
            } else {
                root.val = findRight(root.right).val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    public TreeNode findLeft(TreeNode root) {
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        //返回父节点，以便删除
        return cur;
    }

    public TreeNode findRight(TreeNode root) {
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        //返回父节点，以便删除
        return cur;
    }
}
