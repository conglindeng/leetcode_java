package leetcode.middle;

import java.util.Arrays;

public class MaxProduct_152 {
    public int maxProduct(int[] nums) {
        //dp[i]表i位置处最大的乘积 dp[i]=max(dp[i-1]*nums[i],nums[i])
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] minDp = new int[length];
        int[] maxDp = new int[length];
        System.arraycopy(nums, 0, maxDp, 0, nums.length);
        System.arraycopy(nums, 0, minDp, 0, nums.length);
        for (int i = 1; i < nums.length; i++) {
            minDp[i] = Math.min(minDp[i], Math.min(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]));
            maxDp[i] = Math.max(maxDp[i], Math.max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]));
        }
        int res = maxDp[0];
        for (int i = 1; i < length; i++) {
            if (maxDp[i] > res) {
                res = maxDp[i];
            }
        }
        return res;
    }

    public int maxProduct_Optimize(int[] nums) {
        //dp[i]表i位置处最大的乘积 dp[i]=max(dp[i-1]*nums[i],nums[i])
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int minDp = nums[0];
        int maxDp = nums[0];
        int res = nums[0];
        for (int i = 1; i < length; i++) {
            int temp = minDp;
            minDp = Math.min(nums[i], Math.min(maxDp * nums[i], temp * nums[i]));
            maxDp = Math.max(nums[i], Math.max(maxDp * nums[i], temp * nums[i]));
            res = Math.max(res, maxDp);
        }
        return res;
    }
}
