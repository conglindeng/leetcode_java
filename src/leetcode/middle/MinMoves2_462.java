package leetcode.middle;

import java.util.Arrays;

/**
 * @ClassName MinMoves2_462
 
 * @Version 1.0
 */
public class MinMoves2_462 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - mid);
        }
        return res;
    }
}
