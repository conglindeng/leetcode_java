package tree;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetHeight {

    public int getHeight_Recursive(TreeNode root){
        if(root==null)
            return 0;
        int leftHeight=getHeight_Recursive(root.left);
        int rightHeight=getHeight_Recursive(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    public int getHeight_LevelTravel(TreeNode root){
        if(root==null)
            return 0;
        Queue<TreeNode> work=new LinkedList<>();
        work.add(root);
        int count=0;
        while(!work.isEmpty()){
            count++;
            List<TreeNode> nextLevel=new ArrayList<>();
            while(!work.isEmpty()){
                TreeNode poll = work.poll();
                if(poll.left!=null)
                    nextLevel.add(poll.left);
                if(poll.right!=null)
                    nextLevel.add(poll.right);
            }
            work.addAll(nextLevel);
        }
        return count;
    }


    //todo； 后序遍历计算高度


}
