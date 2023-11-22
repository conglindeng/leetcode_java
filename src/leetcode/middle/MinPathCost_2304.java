package leetcode.middle;

import java.util.Arrays;

public class MinPathCost_2304 {

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int point = grid[i][j];
                int[] ints = moveCost[point];
                for (int k = 0; k < n; k++) {
                    if (dp[i + 1][k] == -1) {
                        dp[i + 1][k] = dp[i][j] + ints[k] + point;
                    } else {
                        dp[i + 1][k] = Math.min(dp[i][j] + ints[k] + point, dp[i + 1][k]);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(dp[m - 1][i]+grid[m-1][i], res);
        }
        return res;
    }
}
