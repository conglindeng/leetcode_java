package newcode;

import struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class NC9_HasPathSum {

    //1.递归调用
    //2.先序遍历-不停的相加,弹出再相减


    private boolean res;

    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return bool布尔型
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        // write code here

        res = false;
        if (root == null) {
            return false;
        }
        int curSum = 0;
        bfs(root, curSum, sum);

        return res;
    }


    private void bfs(TreeNode root, int curSum, int sum) {
        curSum += root.val;
        if (root.left == null && root.right == null && sum == curSum) {
            res = true;
            return;
        }
        if (root.left != null && !res) {
            bfs(root.left, curSum, sum);
        }
        if (root.right != null && !res) {
            bfs(root.right, curSum, sum);
        }
    }


    public boolean hasPathSumOptimize(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return bfs_opt(root,sum,0);
    }


    private boolean bfs_opt(TreeNode root,int sum,int curSum){
        if(root==null){
            return false;
        }
        curSum+=root.val;
        if(root.left==null&&root.right==null&&curSum==sum){
            return true;
        }
        return bfs_opt(root.left,sum,curSum)||bfs_opt(root.right,sum,curSum);
    }
}
