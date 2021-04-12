package tree;

import struct.ListNode;
import struct.TreeNode;

import java.util.*;

public class Traverse {
    public static List<Integer> leverTraverse(TreeNode root){
        if(root==null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> workRecord=new LinkedList<>();
        workRecord.addLast(root);
        while(!workRecord.isEmpty()){
            TreeNode pop = workRecord.pollFirst();
            result.add(pop.val);
            if(pop.left!=null){
                workRecord.addLast(pop.left);
            }
            if(pop.right!=null){
                workRecord.addLast(pop.right);
            }
        }
        return result;
    }

    public static List<Integer> DLRTraverse(TreeNode root){
        if(root==null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> workRecord=new LinkedList<>();
        workRecord.push(root);
        while(!workRecord.isEmpty()){
            TreeNode pop = workRecord.pop();
            result.add(pop.val);
            if(pop.right!=null){
                workRecord.push(pop.right);
            }
            if(pop.left!=null){
                workRecord.push(pop.left);
            }
        }
        return result;
    }
    public static List<Integer> LDRTraverse(TreeNode root){
        if(root==null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> workRecord=new LinkedList<>();
        TreeNode cur=root;
        while(cur!=null || !workRecord.isEmpty()){
            if(cur!=null){
                workRecord.push(cur);
                cur=cur.left;
            }else{
                cur = workRecord.pop();
                result.add(cur.val);
                cur=cur.right;
            }
        }
        return result;
    }
    public List<Integer> LRDTraverse(TreeNode root){
        if(root==null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();


        return result;
    }
}
