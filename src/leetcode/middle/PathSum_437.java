package leetcode.middle;

import struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum_437 {
    /**
     * 给定一个二叉树，它的每个结点都存放着一个整数值。
     *
     * 找出路径和等于给定数值的路径总数。
     *
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     *
     * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root,int targetSum){
        Map<Integer,Integer> count=new HashMap<>();
        count.put(0,1);
        return recursionPathSum(root,count,targetSum,0);
    }

    private int recursionPathSum(TreeNode root,Map<Integer,Integer> count,int target,int sum){
        if (root == null)
            return 0;
        int res = 0, curSum = sum;
        curSum += root.val;
        if (count.containsKey(curSum - target)) {
            res += count.get(curSum - target);
        }
        count.put(curSum, count.getOrDefault(curSum, 0) + 1);
        res += recursionPathSum(root.left, count, target, curSum);
        res += recursionPathSum(root.right, count, target, curSum);
        if (count.get(curSum) == 1) {
            count.remove(curSum);
        } else {
            count.put(curSum, count.get(curSum) - 1);
        }
        return res;
    }
}
