package leetcode.middle;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ExclusiveTime_636 {

    private static final String BEGIN = "start";
    public static final String START = "start";

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<int[]> work = new ArrayDeque<>();
        for (String log : logs) {
            String[] split = log.split(":");
            int index = Integer.parseInt(split[0]);
            int time = Integer.parseInt(split[2]);
            if (START.equals(split[1])) {
                if (!work.isEmpty()) {
                    res[work.peekLast()[0]] += time - work.peekLast()[1];
                    //work.peekLast()[1] = time;
                }
                work.addLast(new int[]{index, time});
            } else {
                int[] last = work.pollLast();
                res[index] += time - last[1] + 1;
                if (!work.isEmpty()) {
                    work.peekLast()[1] = time + 1;
                }
            }
        }
        return res;
    }
}
