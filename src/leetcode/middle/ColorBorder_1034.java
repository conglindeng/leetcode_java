package leetcode.middle;

public class ColorBorder_1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        // 从grid[row][col]出发，向上下左右进行广度或者深度优先遍历
        // 假设grid[i][j]与grid[row][col]相邻，则判断两个颜色时候一致，如果一致的话，说明应该以grid[i][j]做同样的操作
        //      否则将grid[i][j]染色即可。
        // 另，是否已经染色处理过，还需要一个额外的数组维护一下状态
    }
}
