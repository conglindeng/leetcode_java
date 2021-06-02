package leetcode.easy;

import struct.TreeNode_T;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IncreasingBST_897 {
    public static TreeNode_T<Integer> increasingBST(TreeNode_T<Integer> root){
        Stack<TreeNode_T<Integer>> stack=new Stack<>();
        TreeNode_T<Integer> head=new TreeNode_T<>(-1);
        TreeNode_T<Integer> curHead=head;
        TreeNode_T<Integer> cur=root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            if(!stack.isEmpty()){
                TreeNode_T<Integer> poll = stack.pop();
                curHead.right=new TreeNode_T<>(poll.val);
                curHead=curHead.right;
                cur=poll.right;
            }
        }
        return head.right;
    }
}
