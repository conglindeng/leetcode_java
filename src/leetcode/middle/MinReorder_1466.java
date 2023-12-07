package leetcode.middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinReorder_1466 {

    int res = 0;
    Map<Integer, List<Integer>> neighbors;
    Map<Integer, Set<Integer>> edges;

    public int minReorder(int n, int[][] connections) {
        neighbors = new HashMap<>();
        edges = new HashMap<>();

        for (int i = 0; i < n; i++) {
            neighbors.putIfAbsent(i, new ArrayList<>());
            edges.putIfAbsent(i, new HashSet<>());
        }
        for (int[] connection : connections) {
            neighbors.get((connection[0])).add(connection[1]);
            neighbors.get((connection[1])).add(connection[0]);
            edges.get(connection[0]).add(connection[1]);
        }
        LinkedList<Integer> work = new LinkedList<>();
        work.addLast(0);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        bfs(visited, work);
        return res;
    }

    private void bfs(Set<Integer> visited, Deque<Integer> work) {
        while (work.size() > 0) {
            Integer cur = work.pollFirst();
            for (Integer i : neighbors.get(cur)) {
                if (!visited.contains(i)) {
                    if (edges.get(cur).contains(i)) {
                        res++;
                    }
                    visited.add(i);
                    work.addLast(i);
                }
            }
        }
    }

}
