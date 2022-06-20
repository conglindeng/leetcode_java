package leetcode.middle;

import java.util.Arrays;

public class FindPairs_532 {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int curIdx = getCurIdx(nums, nums[i] + k, i + 1);
            if (curIdx != -1) {
                res++;
            }
        }
        return res;
    }

    //如果有多个targer，找到其中一个即可
    private int getCurIdx(int[] nums, int target, int start) {
        int left = start, right = nums.length-1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
