package leetcode.middle;

import java.util.Arrays;

public class MinFallingPathSum_931 {
    public int minFallingPathSum(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height + 1][width];
        for (int m = 1; m <= height; m++) {
            Arrays.fill(dp[m], 0, width, Integer.MAX_VALUE);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j >= 1) {
                    dp[i + 1][j] = Math.min(dp[i][j - 1] + matrix[i][j], dp[i + 1][j]);
                }
                if (j < height - 1) {
                    dp[i + 1][j] = Math.min(dp[i][j + 1] + matrix[i][j], dp[i + 1][j]);
                }
                dp[i + 1][j] = Math.min(dp[i][j] + matrix[i][j], dp[i + 1][j]);
            }
        }
        return Arrays.stream(dp[height]).min().getAsInt();
        //return dp[heights][width];
    }

    public int minFallingPathSum_Optimize(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        for (int i = height-2; i >=0; i--) {
            for (int j = 0; j < width; j++) {
                int best=matrix[i+1][j];
                if (j >= 1) {
                     best= Math.min(matrix[i+1][j-1], best);
                }
                if (j < height - 1) {
                    best = Math.min(matrix[i+1][j+1], best);
                }
                matrix[i][j]+=best;
            }
        }
        return Arrays.stream(matrix[0]).min().getAsInt();
    }
}
