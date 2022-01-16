package leetcode.middle;

public class IncreasingTriplet_334 {
    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        int[] min = new int[length];
        int cur = nums[0];
        for (int i = 0; i < length; i++) {
            cur = Math.min(cur, nums[i]);
            min[i] = cur;
        }
        int[] max = new int[length];
        cur = nums[length - 1];
        for (int j = length - 1; j >= 0; j--) {
            cur = Math.max(cur, nums[j]);
            max[j] = cur;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > min[i - 1] && nums[i] < max[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet_Greed(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }
}
