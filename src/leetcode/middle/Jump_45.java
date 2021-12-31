package leetcode.middle;

import java.util.Arrays;

public class Jump_45 {
    public int jump(int[] nums) {
        // m从0到i-1，如果 nums[m]+m>=i
        // 则 dp[i]=Math.min(dp[m]+1,dp[i]);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public int jump_Optimize(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                }
            }
        }
        return dp[nums.length - 1];
    }
}
