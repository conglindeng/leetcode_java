package leetcode.easy;

import struct.TreeNode;

import java.util.*;

public class IsCousins_993 {
    /**
     * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
     *
     * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
     *
     * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
     *
     * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public boolean isCousins(TreeNode root,int x, int y){
        if(root==null){
            return false;
        }
        Deque<TreeNode> work=new LinkedList<>();
        int height=1;
        work.add(root);
        int heightx=0;
        int heighty=0;
        TreeNode parentx=null;
        TreeNode parenty=null;
        while(!work.isEmpty()){
            List<TreeNode> nextLevel=new ArrayList<>();
            while(!work.isEmpty()){
                TreeNode pop = work.pop();
                if(pop.left!=null){
                    nextLevel.add(pop.left);
                    if(pop.left.val==x){
                        heightx=height;
                        parentx=pop;
                    }
                    if(pop.left.val==y){
                        heighty=height;
                        parenty=pop;
                    }
                }
                if(pop.right!=null){
                    nextLevel.add(pop.right);

                    if(pop.right.val==x){
                        heightx=height;
                        parentx=pop;
                    }
                    if(pop.right.val==y){
                        heighty=height;
                        parenty=pop;
                    }
                }
            }
            if(parentx!=null&&parenty!=null)
                break;
            height++;
            work.addAll(nextLevel);
        }
        return heightx==heighty&&parentx!=parenty;
    }
}
