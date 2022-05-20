package leetcode.middle;


import java.util.TreeSet;

public class CountBattleships_419 {
    public int countBattleships(char[][] board) {
        int height = board.length;
        int width = board[0].length;
        int res = 0;
        TreeSet<String> XIdxSet = new TreeSet<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'X') {
                    if (!XIdxSet.contains(getLocation(i - 1, j))
                            && !XIdxSet.contains(getLocation(i, j - 1))) {
                        res += 1;
                    }
                    XIdxSet.add(getLocation(i, j));
                }
            }
        }
        return res;
    }

    private String getLocation(int i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(",");
        sb.append(j);
        return sb.toString();
    }


    public int countBattleships_Optimize(char[][] board) {
        int height = board.length;
        int width = board[0].length;
        int res = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    res++;
                }
            }
        }
        return res;
    }

}
