package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence_1403 {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int curSum = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            curSum += nums[i];
            res.add(nums[i]);
            if (curSum > sum - curSum) {
                break;
            }
        }
        return res;
    }
}
