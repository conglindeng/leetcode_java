package leetcode.easy;

import struct.TreeNode;

import java.util.*;
import java.util.function.Consumer;

public class LeafSimilar_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return getLeafs(root1).equals(getLeafs(root2));
    }

    public List<Integer> getLeafs(TreeNode root ) {
        List<Integer> result=new ArrayList<>();
        TreeNode cur = root;
        Deque<TreeNode> work = new LinkedList<>();
        while (!work.isEmpty() ||cur!=null){
            if(cur!=null){
                work.push(cur);
                cur=cur.left;
            }else{
                TreeNode pop = work.pop();
                if(pop.left==null && pop.right==null){
                    result.add(pop.val);
                }
                cur=cur.right;
            }
        }
        return result;
    }
}
