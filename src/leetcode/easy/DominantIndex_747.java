package leetcode.easy;

public class DominantIndex_747 {
    public int dominantIndex(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length < 2) {
            return 0;
        }
        int idx = 0;
        int max = nums[0];
        int secondMax = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                idx = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return max >= secondMax * 2 ? idx : -1;
    }
}
