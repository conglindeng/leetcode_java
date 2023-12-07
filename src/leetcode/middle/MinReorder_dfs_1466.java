package leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

public class MinReorder_dfs_1466 {


    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Pair<Integer, Integer>>> edges = new HashMap<>();
        for (int i = 0; i < n; i++) {
            edges.putIfAbsent(i, new ArrayList<>());
        }
        for (int[] connection : connections) {
            edges.get(connection[0]).add(new Pair<>(connection[1], 0));
            edges.get(connection[1]).add(new Pair<>(connection[0], 1));
        }
        return dfs(0, -1, edges);
    }

    private int dfs(int cur, int parent, Map<Integer, List<Pair<Integer, Integer>>> edges) {
        int res = 0;
        List<Pair<Integer, Integer>> pairList = edges.get(cur);
        for (Pair<Integer, Integer> pair : pairList) {
            Integer next = pair.getKey();
            Integer flag = pair.getValue();
            if (next != parent) {
                if (flag == 0) {
                    res++;
                }
                res += dfs(next, cur, edges);
            }
        }
        return res;
    }

}
