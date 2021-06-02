import leetcode.middle.PathSum_437;
import leetcode.middle.Rob_TreeNode_337;
import tree.GetHeight;
import struct.TreeNode;

public class TreeNodeMain {
    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        TreeNode treeNode6=new TreeNode(6);
        TreeNode treeNode7=new TreeNode(7);
        TreeNode treeNode8=new TreeNode(8);
        treeNode1.left=treeNode2;
        //treeNode2.left=treeNode3;
        //treeNode3.left=treeNode5;
        treeNode5.right=treeNode6;
        //treeNode1.right=treeNode4;
        //treeNode2.right=treeNode5;
//        treeNode3.left=treeNode6;
//        treeNode3.right=treeNode7;
//        treeNode4.left=treeNode8;

        System.out.println(new Rob_TreeNode_337().rob(treeNode1));


    }
}
