import leetcode.middle.CBTInserter_OptimizeWithBitCount_919;
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

        CBTInserter_OptimizeWithBitCount_919 test = new CBTInserter_OptimizeWithBitCount_919(treeNode4);
        test.insert(2);
        test.insert(3);
        test.insert(4);
        test.insert(5);
        test.insert(6);
        test.insert(6);

        System.out.println();

    }

}
