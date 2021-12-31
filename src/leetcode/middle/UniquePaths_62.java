package leetcode.middle;

public class UniquePaths_62 {
    int res = 0;

    public int uniquePaths(int m, int n) {
        bfs(0, 0, m, n, new boolean[m][n]);
        return res;
    }

    private void bfs(int m, int n, int height, int width, boolean[][] flag) {
        if (m >= height || n >= width || flag[m][n]) {
            return;
        }
        if (m == height - 1 && n == width - 1) {
            res++;
            return;
        }
        flag[m][n] = true;
        bfs(m + 1, n, height, width, flag);
        bfs(m, n + 1, height, width, flag);
        flag[m][n] = false;
    }


    public int uniquePaths_Dp(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }

        }
        return dp[m - 1][n - 1];
    }


}
