package leetcode.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class IsValidSudoku_36 {
    Map<Integer, TreeSet<Character>> columnWork = new HashMap<>();
    Map<Integer, TreeSet<Character>> rowWork = new HashMap<>();
    Map<Integer, TreeSet<Character>> subWork = new HashMap<>();


    public boolean isValidSudoku(char[][] board) {
        int height = board.length;
        int width = board[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int subIndex = i / 3 + j / 3;
                boolean validate = validateRowOrColumn(board[i][j], i, columnWork) && validateRowOrColumn(board[i][j], j, rowWork) && validateRowOrColumn(board[i][j], subIndex, subWork);
                if (!validate) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validateRowOrColumn(char c, int index, Map<Integer, TreeSet<Character>> work) {
        TreeSet<Character> integers = work.get(index);
        if (integers == null) {
            integers = new TreeSet<>();
        }
        if (c <= '9' && c >= '0' && integers.contains(c)) {
            return false;
        }
        if (c <= '9' && c >= '0'){
            integers.add(c);
        }
        work.put(index, integers);
        return true;
    }
}
