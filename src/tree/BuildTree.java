package tree;

import struct.TreeNode;

public class BuildTree {

    /**
     * 根据先序和中序构造二叉树
     * @param DLR 先序
     * @param LDR 中序
     * @return 树
     */
    public TreeNode buildTreeByDLRAndLDR(String DLR,String LDR){
        char c = DLR.charAt(0);
        TreeNode root=new TreeNode(c-48);
        //String left=LDR.split(c);
        //root.left=buildTreeByLRDAndLDR();


        return null;
    }

    /**
     * 根据后序和中序构造二叉树
     * @param LRD 后序
     * @param LDR 中序
     * @return 树
     */
    public TreeNode buildTreeByLRDAndLDR(String LRD,String LDR){


        return null;
    }
}
