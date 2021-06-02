package leetcode.easy;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IncreasingBST_897 {
    public static TreeNode<Integer> increasingBST(TreeNode<Integer> root){
        Stack<TreeNode<Integer>> stack=new Stack<>();
        TreeNode<Integer> head=new TreeNode<>(-1);
        TreeNode<Integer> curHead=head;
        TreeNode<Integer> cur=root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            if(!stack.isEmpty()){
                TreeNode<Integer> poll = stack.pop();
                curHead.right=new TreeNode<>(poll.val);
                curHead=curHead.right;
                cur=poll.right;
            }
        }
        return head.right;
    }
}
