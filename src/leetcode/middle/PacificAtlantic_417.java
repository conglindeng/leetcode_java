package leetcode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlantic_417 {

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int[][] heights;

    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = heights;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            bfs(i, 0, pacific);
        }
        for (int i = 1; i < n; i++) {
            bfs(0, i, pacific);
        }

        for (int i = 0; i < m; i++) {
            bfs(i, n - 1, atlantic);
        }
        for (int i = 0; i < n - 1; i++) {
            bfs(m - 1, i, atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> item = new ArrayList<>();
                    item.add(i);
                    item.add(j);
                    res.add(item);
                }
            }
        }
        return res;

    }

    private void bfs(int i, int j, boolean[][] flag) {
        if (flag[i][j]) {
            return;
        }
        flag[i][j] = true;
        Queue<int[]> work = new LinkedList<>();
        work.offer(new int[]{i, j});
        while (!work.isEmpty()) {
            int[] poll = work.poll();
            for (int[] dir : dirs) {
                int m = poll[0] + dir[0];
                int n = poll[1] + dir[1];
                if (m >= 0 && m < this.m && n >= 0 && n < this.n && !flag[m][n] && heights[m][n] >= heights[poll[0]][poll[1]]) {
                    flag[m][n] = true;
                    work.offer(new int[]{m, n});
                }
            }
        }
    }

}
