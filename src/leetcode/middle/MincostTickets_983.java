package leetcode.middle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MincostTickets_983 {

    int[] cache = new int[366];
    Set<Integer> daySet = new HashSet<>();
    int[] costs;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        for (int day : days) {
            daySet.add(day);
        }
        Arrays.fill(cache, -1);
        return dp(1);
    }

    private int dp(int day) {
        if (day > 365) {
            return 0;
        }
        if (cache[day] != -1) {
            return cache[day];
        }
        if (daySet.contains(day)) {
            cache[day] = Math.min(Math.min(costs[0] + dp(day + 1), costs[1] + dp(day + 7)), costs[2] + dp(day + 30));
        } else {
            cache[day] = dp(day + 1);
        }
        return cache[day];
    }

}
