package interview;

public class numIslands {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] accessed;

    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        accessed = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if(!accessed[i][j]){
                        res++;
                        findAllConnected(grid, i, j);
                    }
                }
            }
        }
        return res;
    }

    private void findAllConnected(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return;
        }
        if (j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0' || accessed[i][j]) {
            return;
        }
        accessed[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            findAllConnected(grid, x, y);
        }
    }

    //[["0","1","0"],["1","0","1"],["0","1","0"]]
    public static void main(String[] args) {
        new numIslands().numIslands(new char[][]{
            {'0','1','0'},
            {'1','0','1'},
            {'0','1','0'}
        });
    }
}
