package leetcode.difficult;

import java.util.*;

public class BusiestServers_1606 {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        List<Integer> res = new ArrayList<>();
        if (k == 1) {
            res.add(0);
            return res;
        }
        TreeSet<Integer> ava = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            ava.add(i);
        }
        int[] count = new int[k];
        int maxCount = -1;
        PriorityQueue<int[]> work = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < arrival.length; i++) {
            while (!work.isEmpty() && work.peek()[0] <= arrival[i]) {
                int[] poll = work.poll();
                ava.add(poll[1]);
            }
            if (ava.isEmpty()) {
                continue;
            }
            Integer next = ava.ceiling(i % k);
            if (next == null) {
                next = ava.pollFirst();
            }
            count[next]++;
            work.add(new int[]{arrival[i] + load[i], next});
            ava.remove(next);
        }
        for (int i = 0; i < k; i++) {
            maxCount = Math.max(maxCount, count[i]);
        }
        for (int i = 0; i < k; i++) {
            if (count[i] == maxCount) {
                res.add(i);
            }
        }
        return res;
    }
}
