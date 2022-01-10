package leetcode.middle;

public class Exist_79 {
    boolean res = false;

    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width = board[0].length;
        boolean[][] used = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (res) {
                    return true;
                }
                bfs(board, height, width, i, j, used, 0, word);
            }
        }
        return res;
    }


    private void bfs(char[][] board, int height, int width, int m, int n, boolean[][] used, int idx, String word) {
        if (res) {
            return;
        }
        if (m < 0 || m > height - 1) {
            return;
        }
        if (n < 0 || n > width - 1) {
            return;
        }
        if (used[m][n]) {
            return;
        }
        char c = word.charAt(idx);
        if (c != board[m][n]) {
            return;
        }
        if (idx == word.length() - 1) {
            res = true;
            return;
        }
        used[m][n] = true;
        bfs(board, height, width, m + 1, n, used, idx + 1, word);
        bfs(board, height, width, m, n + 1, used, idx + 1, word);
        bfs(board, height, width, m - 1, n, used, idx + 1, word);
        bfs(board, height, width, m, n - 1, used, idx + 1, word);
        used[m][n] = false;
    }
}
