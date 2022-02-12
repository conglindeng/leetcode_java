package leetcode.easy;

import java.util.Arrays;

public class MinimumDifference_1984 {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= length - k; i++) {
            res = Math.min(res, nums[i + k - 1] - nums[i]);
        }
        return res;
    }
}
