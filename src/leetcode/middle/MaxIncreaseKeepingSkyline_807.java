package leetcode.middle;

public class MaxIncreaseKeepingSkyline_807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;
        int[] col = new int[width];
        int[] row = new int[height];
        for (int i = 0; i < height; i++) {
            int max = 0;
            for (int j = 0; j < width; j++) {
                col[j] = Math.max(col[j], grid[i][j]);
                max = Math.max(max, grid[i][j]);
            }
            row[i] = max;
        }
        int res = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res += Math.min(col[j], row[i]) - grid[i][j];
            }
        }
        return res;
    }
}
