package leetcode.middle;

public class FindMin_153 {
    public int findMin(int[] nums) {
//        left<mid<right 则在left和mid中
//        left<right<mid 不可能
//        mid<right<left 在left和mid中
//        mid<left<right 不可能
//        right<mid<left  不可能
//        right<left<mid  在mid和right中

        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            if (right - left == 1) {
                return Math.min(nums[left], nums[right]);
            }
            mid = left + (right - left + 1) / 2;
            int l = nums[left];
            int m = nums[mid];
            int r = nums[right];
            if (left < m && m < r) {
                right = mid;
            } else if (m < r && r < l) {
                right = mid;
            } else if (r < l && l < m) {
                left = mid;
            }
        }
        return nums[left];
    }

    public int findMin_Optimize(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                right = mid + 1;
            } else {
                left = mid;
            }
        }
        return nums[left];
    }
}
