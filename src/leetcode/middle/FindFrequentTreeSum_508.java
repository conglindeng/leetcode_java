package leetcode.middle;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFrequentTreeSum_508 {

    private int res = -1;

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
