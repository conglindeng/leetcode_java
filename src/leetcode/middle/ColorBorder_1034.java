package leetcode.middle;

public class ColorBorder_1034 {
    int[][] flag;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        // 从grid[row][col]出发，向上下左右进行广度或者深度优先遍历
        // 假设grid[i][j]与grid[row][col]相邻，则判断两个颜色时候一致，如果一致的话，说明应该以grid[i][j]做同样的操作
        //      否则将grid[i][j]染色即可。
        // 另，是否已经染色处理过，还需要一个额外的数组维护一下状态
        if (grid == null || grid.length == 0) {
            return grid;
        }
        flag = new int[grid.length][grid[0].length];
        doColorBorder(grid, row, col, color, grid[row][col]);
        return grid;
    }

    private void doColorBorder(int[][] grid, int row, int col, int color, int temp) {
        if (row < 0 || row >= grid.length) {
            return;
        }
        if (col < 0 || col >= grid[0].length) {
            return;
        }
        if (flag[row][col] == 1) {
            return;
        }
        flag[row][col] = 1;
        if (grid[row][col] == temp) {
            doColorBorder(grid, row - 1, col, color, temp);
            doColorBorder(grid, row + 1, col, color, temp);
            doColorBorder(grid, row, col - 1, color, temp);
            doColorBorder(grid, row, col + 1, color, temp);
        } else {
            grid[row][col] = color;
        }
    }
}
