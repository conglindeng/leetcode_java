package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter_Optimize_933 {

    Queue<Integer> work;

    public RecentCounter_Optimize_933() {
        work = new LinkedList<>();
    }

    public int ping(int t) {
        work.offer(t);
        int m = t - 3000;
        while (!work.isEmpty() && work.peek() < m) {
            work.poll();
        }
        return work.size();
    }

}