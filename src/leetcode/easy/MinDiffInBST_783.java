package leetcode.easy;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MinDiffInBST_783 {
    public int minDiffInBST(TreeNode<Integer> root){
        List<Integer> ldr = LDR(root);
        int result=Integer.MAX_VALUE;
        for (int i = 1; i < ldr.size(); i++) {
            result=Math.min(result,ldr.get(i)-ldr.get(i-1));
        }
        return result;
    }

    private List<Integer> LDR(TreeNode<Integer> root){
        List<Integer> result=new ArrayList<>();
        Deque<TreeNode<Integer>> work=new LinkedList<>();
        TreeNode<Integer> cur=root;
        while(!work.isEmpty()||cur!=null){
            while(cur!=null){
                work.push(cur);
                cur=cur.left;
            }
            if(!work.isEmpty()){
                TreeNode<Integer> pop = work.pop();
                result.add(pop.val);
                if(pop.right!=null){
                    cur=pop.right;
                }
            }
        }
        return result;
    }


}
