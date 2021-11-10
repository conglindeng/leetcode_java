package leetcode.middle;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFrequentTreeSum_508 {

    private int res = -1;

    /**
     * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
     *
     * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> info = new HashMap<>();

        //获取频率最大的数值
        getSum(info,root);
        List<Integer> nums=new ArrayList<>();
        info.entrySet().forEach(item->{
            if(res==item.getValue()){
                nums.add(item.getKey());
            }
        });
        int[] r=new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            r[i]=nums.get(i);
        }
        return r;
    }


    private int getSum(Map<Integer, Integer> info, TreeNode root) {
        int leftSum = 0;
        if (root.left != null) {
            leftSum = getSum(info, root.left);
        }
        int rightSum = 0;
        if (root.right != null) {
            rightSum = getSum(info, root.right);
        }
        int sum = leftSum + rightSum + root.val;
        updateInfoAndMaxCount(sum, info);
        return sum;
    }

    private void updateInfoAndMaxCount(int curSum, Map<Integer, Integer> info) {
        int integer = info.getOrDefault(curSum, 0)+1;
        res = Math.max(integer, res);
        info.put(curSum, integer);
    }

}
