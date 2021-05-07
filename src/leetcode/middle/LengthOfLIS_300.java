package leetcode.middle;

import java.util.Arrays;

public class LengthOfLIS_300 {
    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     *
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums){
        int length = nums.length;
        int[] dp=new int[length+1];
        Arrays.fill(dp,1);
        int result=0;
        for(int i=1;i<length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i])
                    dp[i+1]=Math.max(dp[i+1],dp[j+1]+1);
            }
            result=Math.max(result,dp[i+1]);
        }
        return result;
    }
}
