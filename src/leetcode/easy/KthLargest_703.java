package leetcode.easy;

import java.util.PriorityQueue;

public class KthLargest_703 {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest_703(int k, int[] nums) {
        this.k=k;
        this.pq=new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
    }

    public int add(int val) {
        pq.add(val);
        while(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}
