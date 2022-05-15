import leetcode.middle.Codec_Optimize_Plus_449;
import struct.TreeNode;

public class TreeNodeMain {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        //treeNode2.left = treeNode4;
        //treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;

        //treeNode6.left = treeNode7;


        Codec_Optimize_Plus_449 c = new Codec_Optimize_Plus_449();
        String serialize = c.serialize(treeNode1);
        //String serialize = "1 2 3 # # 6 ";
        TreeNode deserialize = c.deserialize(serialize);

    }


}
