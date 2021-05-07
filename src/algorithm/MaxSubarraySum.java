package algorithm;

import java.util.Arrays;

public class MaxSubarraySum {
    /**
     * 输入一个整形数组,数组里有正数也有负数。数组中连续的一个或多个整数组成一个子数组,每个子数组都有一个和。求所有子数组的和的最大值。要求时间复杂度为 O(n)。
     *
     * @param nums
     * @return
     */
    public int MaxSubarraySum(int[] nums){

        int[] dp=new int[nums.length+1];
        int result=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i+1]=Math.max(dp[i]+nums[i],nums[i]);
            result=Math.max(result,dp[i+1]);
        }
        return result;
        //return Arrays.stream(dp).max().getAsInt();
    }


    /**
     * 输入一个整形数组,数组里有正数也有负数。数组中连续的一个或多个整数组成一个子数组,每个子数组都有一个和。求所有子数组的和的最大值。要求时间复杂度为 O(n)。
     * 暴力解法 时间复杂度（O(n^2)）
     * @param nums
     * @return
     */
    public int MaxSubarraySum_Violent(int[] nums){
        int result=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curSum=0;
            for (int j = i; j < nums.length; j++) {
                curSum+=nums[j];
                result=Math.max(curSum,result);
            }
        }
        return result;
    }
}
