import leetcode.middle.FindBottomLeftValue_513;
import struct.TreeNode;

public class TreeNodeMain {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(14);
        TreeNode treeNode3 = new TreeNode(-3);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(1);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        //treeNode2.left = treeNode4;
        //treeNode4.left = treeNode5;

        treeNode3.right = treeNode6;

        treeNode6.left = treeNode7;

        int bottomLeftValue = new FindBottomLeftValue_513().findBottomLeftValue(treeNode1);

    }

}
