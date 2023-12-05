package leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumFuelCost_2477 {

    long res = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int[] road : roads) {
            int m = road[0];
            int n = road[1];
            edges.putIfAbsent(m, new ArrayList<>());
            edges.putIfAbsent(n, new ArrayList<>());
            edges.get(m).add(n);
            edges.get(n).add(m);
        }
        bfs(0, -1, edges, seats);
        return res;
    }

    private long bfs(int cur, int pre, Map<Integer, List<Integer>> edges, int seats) {
        long peopleSum = 1;
        List<Integer> list = edges.getOrDefault(cur, new ArrayList<>());
        for (Integer l : list) {
            if (l != pre) {
                long peopleCnt = bfs(l, cur, edges, seats);
                peopleSum += peopleCnt;
                res += (peopleCnt + seats - 1) / seats;
            }
        }
        return peopleSum;
    }

}
