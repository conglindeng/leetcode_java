package leetcode.middle;

public class NumEnclaves_1020 {
    private static final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] flag;

    public int numEnclaves(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        flag = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            dfs(grid, flag, i, 0);
            dfs(grid, flag, i, width - 1);
        }
        for (int i = 0; i < width; i++) {
            dfs(grid, flag, 0, i);
            dfs(grid, flag, height - 1, i);
        }
        int res = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!flag[i][j] && grid[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, boolean[][] flag, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || flag[i][j] || grid[i][j] != 1) {
            return;
        }
        flag[i][j] = true;
        for (int[] dir : dirs) {
            dfs(grid, flag, i + dir[0], j + dir[1]);
        }
    }

}
