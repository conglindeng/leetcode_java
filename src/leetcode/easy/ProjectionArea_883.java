package leetcode.easy;

public class ProjectionArea_883 {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int res = 0;
        int[] left = new int[n];
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                left[i] = Math.max(left[i], grid[i][j]);
                top[j] = Math.max(top[j], grid[i][j]);
                if (grid[i][j] != 0) {
                    res++;
                }
            }        }
        for (int i : left) {
            res += i;
        }
        for (int i : top) {
            res += i;
        }
        return res;
    }
}
