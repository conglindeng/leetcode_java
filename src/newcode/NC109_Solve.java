package newcode;

public class NC109_Solve {
    private int res;

    /**
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] grid) {
        // write code here
        int height = grid.length;
        int width = grid[0].length;
        res = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                bfs(grid, i, j, height, width ,false);
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int i, int j, int height, int width,boolean isExpand) {
        if (i < 0 || i > height - 1 || j < 0 || j > width - 1)
            return;
        if (grid[i][j] == '1') {
            if(!isExpand){
                res++;
            }
            grid[i][j] = '0';
            bfs(grid, i - 1, j, height, width,true);
            bfs(grid, i, j - 1, height, width,true);
            bfs(grid, i + 1, j, height, width,true);
            bfs(grid, i, j + 1, height, width,true);
        }
    }

}
