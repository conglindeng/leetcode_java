import leetcode.easy.PostorderTraversal_145;
import struct.TreeNode;

public class TreeNodeMain {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(10);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
//       treeNode2.right=treeNode5;
//        treeNode4.left=treeNode5;
//        treeNode4.right=treeNode6;

        treeNode3.left = treeNode5;
        treeNode3.right = treeNode7;
        new PostorderTraversal_145().postorderTraversal(treeNode1);

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return bfs(root.left, root.right);
    }


    private boolean bfs(TreeNode f1, TreeNode s2) {
        if (f1 == null && s2 == null) {
            return true;
        }
        if (f1 == null || s2 == null) {
            return false;
        }
        if (f1.val != s2.val) {
            return false;
        }
        return bfs(f1.left, s2.right) && bfs(f1.right, s2.left);
    }
}
