package leetcode.easy;

import java.util.PriorityQueue;

public class KthLargest_059 {

    PriorityQueue<Integer> integers;

    int k;

    public KthLargest_059(int k, int[] nums) {
        this.k = k;
        this.integers = new PriorityQueue<>();
        for (int num : nums) {
            integers.add(num);
            if (integers.size() > k) {
                this.integers.poll();
            }
        }
    }

    public int add(int val) {
        integers.add(val);
        if (integers.size() > k) {
             integers.poll();
        }
        return integers.peek();
    }
}
