package leetcode.middle;

import java.util.*;

public class FindMinHeightTrees_310 {
    int min = Integer.MAX_VALUE;
    Map<Integer, Set<Integer>> nextNo;
    List<Integer> res = new ArrayList<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        nextNo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nextNo.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            nextNo.get(edge[0]).add(edge[1]);
            nextNo.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            visited.add(i);
            bfs(i, visited, nextNo.get(i), new int[]{0});
            visited.remove(i);
        }
        return res;
    }

    private void bfs(int root, Set<Integer> visited, Set<Integer> next, int[] h) {
        h[0] += 1;
        Set<Integer> temp = new HashSet<>();
        for (Integer integer : next) {
            if (!visited.contains(integer)) {
                visited.add(integer);
                temp.addAll(nextNo.get(integer));
            }
        }
        if (temp.size() == 0) {
            if (h[0] < min) {
                min = h[0];
                res = new ArrayList<>();
                res.add(root);
            } else if (h[0] == min) {
                res.add(root);
            }
            return;
        }
        bfs(root, visited, temp, h);
        for (Integer integer : next) {
            visited.remove(integer);
        }
        h[0] -= 1;
    }


    // 上一写法会超过时间限制

    // 考虑能否使用度


}
