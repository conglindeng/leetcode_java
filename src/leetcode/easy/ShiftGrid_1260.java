package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class ShiftGrid_1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int count = m * n;
        int i = k % count;
        List<List<Integer>> res = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            List<Integer> cur = new ArrayList<>();
            for (int l = 0; l < n; l++) {
                int x = (n * j + l - i + count) % count;
                cur.add(grid[x / n][x % n]);
            }
            res.add(cur);
        }
        return res;
    }
}
