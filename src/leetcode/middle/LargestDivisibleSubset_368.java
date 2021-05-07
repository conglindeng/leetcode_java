package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset_368 {
    /**
     * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
     * answer[i] % answer[j] == 0 ，或
     * answer[j] % answer[i] == 0
     * 如果存在多个有效解子集，返回其中任何一个均可。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static List<Integer> largestDivisibleSubset(int[] nums){
        int length = nums.length;
        int[] dp= new int[length+1];
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        int maxSize=dp[0];
        int maxNum=0;
        for (int i = 1; i < length; i++) {
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0)
                    dp[i+1]=Math.max(dp[j+1]+1,dp[i+1]);
            }
            if(dp[i+1]>maxSize){
                maxSize=dp[i+1];
                maxNum=nums[i];
            }
        }
        List<Integer> result = new ArrayList<>();

        if(maxSize==1){
            result.add(nums[0]);
            return result;
        }
        for (int i = length-1; i >= 0 && maxSize > 0; i--) {
            if ((dp[i + 1] == maxSize) && maxNum % nums[i] == 0 && maxNum >= nums[i]) {
                result.add(nums[i]);
                maxSize--;
                maxNum=nums[i];
            }
        }
        return result;
    }
}
