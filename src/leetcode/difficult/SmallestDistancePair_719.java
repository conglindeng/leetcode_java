package leetcode.difficult;

import java.util.Arrays;

public class SmallestDistancePair_719 {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = nums.length;
        int left = 0, right = nums[l - 1] - nums[0];
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < l; i++) {
                cnt += getCurCount(nums, nums[i] - mid, i);
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //找到第一个小于的数
    private int getCurCount(int[] nums, int target, int end) {
        int left = 0, right = end;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return end - left;
    }
}
