import leetcode.middle.PruneTree_814;
import struct.TreeNode;

public class TreeNodeMain {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(0);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(0);
        TreeNode treeNode7 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        //treeNode2.left = treeNode4;
        //treeNode4.left = treeNode5;

        treeNode3.right = treeNode6;

        treeNode6.left = treeNode7;

        TreeNode treeNode = new PruneTree_814().pruneTree(treeNode1);

        System.out.println();

    }

}
