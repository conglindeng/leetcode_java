package leetcode.middle;

import struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LongestZigZag_1372 {
    /**
     * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
     *
     * 选择二叉树中 任意 节点和一个方向（左或者右）。
     * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
     * 改变前进方向：左变右或者右变左。
     * 重复第二步和第三步，直到你在树中无法继续移动。
     * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
     *
     * 请你返回给定树中最长 交错路径 的长度。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-zigzag-path-in-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public int longestZigZag(TreeNode root) {
        Deque<TreeNode> work=new LinkedList<>();
        while(root!=null||!work.isEmpty()){

        }

        return -1;
    }

}
