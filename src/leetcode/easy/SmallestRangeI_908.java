package leetcode.easy;

public class SmallestRangeI_908 {
    public int smallestRangeI(int[] nums, int k) {
        int i = nums.length;
        if (i == 1) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        int res = Integer.MAX_VALUE;
        if (max - min < 2 * k) {
            return 0;
        } else {
            res = Math.min(res, max - min - 2 * k);
        }
        return res;
    }
}
