package leetcode.middle;

public class FindPeakElement_162_Again {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (mid == 0 && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
