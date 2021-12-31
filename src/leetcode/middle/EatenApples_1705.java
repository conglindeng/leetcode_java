package leetcode.middle;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class EatenApples_1705 {
    public int eatenApples(int[] apples, int[] days) {
        //使用map来维护某一天剩余的可吃苹果
        PriorityQueue<int[]> work = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int i = 0;
        int res = 0;
        for (; i < apples.length; i++) {
            while (!work.isEmpty() && work.peek()[0] < i) {
                work.poll();
            }
            if (apples[i] != 0) {
                work.offer(new int[]{i + days[i] - 1, apples[i]});
            }
            if (!work.isEmpty()) {
                int[] peek = work.peek();
                peek[1]--;
                res++;
                if (peek[1] == 0) {
                    work.poll();
                }
            }

        }
        while (true) {
            while (!work.isEmpty() && work.peek()[0] < i) {
                work.poll();
            }
            if (work.isEmpty()) {
                break;
            }
            int[] peek = work.peek();
            peek[1]--;
            res++;
            if (peek[1] == 0) {
                work.poll();
            }
            i++;
        }
        return res;
    }
}
