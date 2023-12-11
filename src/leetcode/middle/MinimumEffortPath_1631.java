package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class MinimumEffortPath_1631 {

    private int res = Integer.MAX_VALUE;

    private static final int[][] direction = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        Map<Integer, Boolean> visited = new HashMap<>();
        visited.put(0, true);
        dfs(heights, 0, 0, visited, 0);
        return res;
    }

    private void dfs(int[][] heights, int x, int y, Map<Integer, Boolean> visited, int need) {
        int m = heights.length;
        int n = heights[0].length;
        if (x == m - 1 && y == n - 1) {
            res = Math.min(res, need);
            return;
        }
        for (int[] ints : direction) {
            int nextX = x + ints[0];
            int nextY = y + ints[1];
            if (nextX < 0 || nextY < 0 || nextX == m || nextY == n) {
                continue;
            }
            if (visited.getOrDefault(nextX * m + nextY, false)) {
                continue;
            }
            visited.put(nextX * m + nextY, true);
            dfs(heights, nextX, nextY, visited, Math.max(need, Math.abs(heights[x][y] - heights[nextX][nextY])));
            visited.put(nextX * m + nextY, false);
        }
    }
}
