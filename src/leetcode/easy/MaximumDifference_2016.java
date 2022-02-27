package leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumDifference_2016 {
    public int maximumDifference(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res = Math.max(res, nums[j] - nums[i]);
            }
        }
        return res;
    }

    public int maximumDifference_Optimize(int[] nums) {
        Deque<Integer> work = new LinkedList<>();
        work.push(nums[0]);
        int res = -1;
        for (int i = 1; i < nums.length; i++) {
            if (work.peek() < nums[i]) {
                res = Math.max(nums[i] - work.peek(), res);
                work.push(work.peek());
            } else {
                work.push(nums[i]);
            }
        }
        return res;
    }

    public int maximumDifference_Optimize_Again(int[] nums) {
        int curMin = nums[0];
        int res = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > curMin) {
                res = Math.max(res, nums[i] - curMin);
            } else {
                curMin = nums[i];
            }
        }
        return res;
    }

}
