package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLength_525 {
    /**
     * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums){
        if(nums.length<2){
            return 0;
        }
        Map<Integer,Integer> sumMap=new HashMap<>();
        sumMap.put(0,-1);
        int sum=0;
        int result=0;
        for(int i=0;i<nums.length ;i++){
            int  num=nums[i];
            if(num==0){
                sum+=-1;
            }else if(num==1){
                sum+=1;
            }

            if(sumMap.containsKey(sum)){
                result=Math.max(result,i-sumMap.get(sum));
            }else{
                sumMap.put(sum,i);
            }
        }

        return result;
    }
}
