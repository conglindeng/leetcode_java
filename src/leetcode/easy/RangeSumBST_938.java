package leetcode.easy;

import struct.TreeNode;

import java.util.Stack;

public class RangeSumBST_938 {
    public static int rangeSumBST(TreeNode root,int low, int high){
        int result=0;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            if(!stack.isEmpty()){
                cur=stack.pop();
                if(cur.val<=high && cur.val>=low){
                    result+=cur.val;
                }else if(cur.val>high){
                    break;
                }
                cur=cur.right;
            }
        }
        return result;
    }
}
