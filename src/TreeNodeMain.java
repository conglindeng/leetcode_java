import struct.TreeNode;
import tree.Traverse;

import java.util.List;

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
        treeNode1.nodes.add(treeNode2);
        treeNode1.nodes.add(treeNode3);
        treeNode1.nodes.add(treeNode4);
        treeNode3.nodes.add(treeNode5);
        treeNode4.nodes.add(treeNode6);
        treeNode4.nodes.add(treeNode7);
        treeNode7.nodes.add(treeNode8);


        List<Integer> firstNum = Traverse.getFirstNum(treeNode1);

    }


}
