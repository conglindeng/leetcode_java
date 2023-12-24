package leetcode.middle;

import java.util.PriorityQueue;

public class MinStoneSum_1926 {

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        for (int pile : piles) {
            priorityQueue.add(pile);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = priorityQueue.poll();
            priorityQueue.add(poll - poll / 2);
        }
        int res = 0;
        for (Integer integer : priorityQueue) {
            res += integer;
        }
        return res;
    }
}
