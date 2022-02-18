package leetcode.middle;

public class Solve_130 {

    private static final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        //对于某个联通的O区域，若要不被X圈住，则必然有一个O是位于矩形的边界上，
        // 在初始的时候，以边界为初始，对存在的O进行扩展，找到联通的所有O，将之标记为不被包围
        // 上一步骤做完后，再遍历所有元素，元素为O且未标记为不被包围的，则替换为X
        int height = board.length;
        int width = board[0].length;
        boolean[][] flag = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            dfs(flag, i, 0, board);
            dfs(flag, i, width - 1, board);
        }
        for (int i = 0; i < width; i++) {
            dfs(flag, 0, i, board);
            dfs(flag, height - 1, i, board);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!flag[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }


    private void dfs(boolean[][] flag, int m, int n, char[][] board) {
        if (m < 0 || m >= board.length || n < 0 || n >= board[0].length || flag[m][n] || board[m][n] != 'O') {
            return;
        }
        flag[m][n] = true;
        for (int[] dir : dirs) {
            dfs(flag, m + dir[0], n + dir[1], board);
        }
    }

}
