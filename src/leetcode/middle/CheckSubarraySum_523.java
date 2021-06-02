package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum_523 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
     *
     * 子数组大小 至少为 2 ，且
     * 子数组元素总和为 k 的倍数。
     * 如果存在，返回 true ；否则，返回 false 。
     *
     * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums,int k){
        int pre=0;
        //key为余数，value为index
        Map<Integer,Integer> count=new HashMap<>();
        count.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            pre=pre+nums[i];
            int mod=pre%k;
            if(count.containsKey(mod)){
                Integer d = count.get(mod);
                if(i-d>=2){
                    return true;
                }
            } else{
              count.put(mod,i);
            }
        }
        return false;
    }


}
