package leetcode.easy;

public class SearchInsert_35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] > target ? 0 : 1;
        }
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left ) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[right] != target && right == nums.length - 1) {
            return right + 1;
        }
        return right;
    }
}
