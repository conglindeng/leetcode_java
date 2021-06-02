package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum_560 {
    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     *
     * 示例 1 :
     *
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums,int k){
        Map<Integer,Integer> count=new HashMap<>();
        //若第一个数正好等于k，此时需要放入0值到map中
        count.put(0,1);
        int pre=0;
        int result=0;
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];
            if(count.containsKey(pre-k)){
                result+=count.get(pre-k);
            }
            count.put(pre,count.getOrDefault(pre,0)+1);
        }
        return result;
    }
}
