package leetcode.middle;

import java.util.*;

public class Solution_398_Optimize {
    private Random random;
    private int[] nums;

    public Solution_398_Optimize(int[] nums) {
        random = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int res = -1;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                cnt++;
                if (random.nextInt(cnt) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}
