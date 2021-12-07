package leetcode.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LargestSumAfterKNegations_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> work = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            work.add(num);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = work.poll();
            if (poll < 0) {
                work.add(-poll);
            } else {
                int m = (k - i) % 2;
                work.add(m == 0 ? poll : -poll);
                break;
            }
        }
        int res = 0;
        while (!work.isEmpty()) {
            res += work.poll();
        }
        return res;
    }
}
