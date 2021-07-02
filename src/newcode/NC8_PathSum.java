package newcode;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NC8_PathSum {
    private ArrayList<ArrayList<Integer>> res =new ArrayList<>();
    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        if(root==null)
            return new ArrayList<>();
        // write code here
        ArrayList<Integer> work=new ArrayList<>();
        dfs(work,root,sum);
        return res;
    }

    private void dfs(ArrayList<Integer> work,TreeNode node,int sum){
        if(node==null){
            return;
        }
        work.add(node.val);
        int index=work.size()-1;
        if(node.left==null&&node.right==null && sum==node.val){
            res.add(new ArrayList<>(work));
        }
        dfs(work,node.left,sum-node.val);
        dfs(work,node.right,sum-node.val);
        work.remove(index);
    }
}
