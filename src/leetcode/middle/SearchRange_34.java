package leetcode.middle;

public class SearchRange_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }
        int right = getLastLessThanOrEquals(nums, target);
        if (right == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{getFirstMoreThanOrEquals(nums, target), right};
    }

    private int getFirstMoreThanOrEquals(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[right] != target) {
            return -1;
        }
        return right;
    }

    private int getLastLessThanOrEquals(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (nums[left] != target) {
            return -1;
        }
        return left;
    }
}
