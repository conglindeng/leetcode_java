package leetcode.easy;

import java.util.*;


public class CountQuadruplets_1995 {
    public int countQuadruplets(int[] nums) {
        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = nums.length - 2; i > 1; i--) {
            count.put(nums[i + 1], count.getOrDefault(nums[i + 1], 0) + 1);
            for (int j = 0; j < i; j++) {
                for (int m = j + 1; m < i; m++) {
                    res += count.getOrDefault(nums[j] + nums[m] + nums[i], 0);
                }
            }
        }
        return res;
    }

    public int countQuadruplets_Optimize(int[] nums) {
        int res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int length = nums.length;
        for (int b = length - 3; b > 0; b--) {
            for (int d = b + 2; d < length; d++) {
                count.put(nums[d] - nums[b + 1], count.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
            }
            for (int a = 0; a < b; a++) {
                res += count.getOrDefault(nums[a] + nums[b], 0);
            }
        }
        return res;
    }
}
