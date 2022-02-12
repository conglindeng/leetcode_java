package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class CountKDifference_2006 {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += count.getOrDefault(nums[i] - k, 0);
            res += count.getOrDefault(nums[i] + k, 0);
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }
        return res;
    }
}
