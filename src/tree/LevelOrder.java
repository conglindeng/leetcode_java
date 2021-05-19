package tree;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public List<List<Integer>> levelOrder_new(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> workQueue=new LinkedList<>();
        workQueue.offer(root);
        while(!workQueue.isEmpty()){
            List<Integer> curVals=new ArrayList<>();
            List<TreeNode> curLevel=new ArrayList<>();
            while(!workQueue.isEmpty()){
                TreeNode poll = workQueue.poll();
                curVals.add(poll.val);
                curLevel.addAll(poll.nodes);
            }
            workQueue.addAll(curLevel);
            result.add(curVals);
        }
        return result;
    }


    public List<List<Integer>> levelOrder(TreeNode root){
        //Queue<TreeNode> workQueue=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        List<TreeNode> curLevel=new ArrayList<>();
        curLevel.add(root);
        while(!curLevel.isEmpty()){
            List<TreeNode> nextLevel=new ArrayList<>();
            List<Integer> curLevelVals=new ArrayList<>();
            curLevel.stream().forEach(x->{
                if(x!=null){
                    curLevelVals.add(x.val);
                    if(x.nodes!=null){
                        nextLevel.addAll(x.nodes);
                    }
                }
            });
            result.add(curLevelVals);
            curLevel=nextLevel;
        }
        return result;
    }

    public int height;

    public int getHeight(TreeNode root,int val){
        height=-1;
        dfs(root,0,val);
        return height;
    }


    private void dfs(TreeNode root,int curLevel,int val){
        if(root.val==val)
            height= curLevel;
        if(root.left!=null)
            dfs(root.left,curLevel+1,val);
        if(root.right!=null)
            dfs(root.right,curLevel+1,val);
    }

}
