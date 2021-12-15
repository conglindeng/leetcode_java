package leetcode.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class IsValidSudoku_36 {
    //每一行一个set
    private Map<Integer, TreeSet<Character>> rowMap = new HashMap<>();
    private Map<Integer, TreeSet<Character>> colMap = new HashMap<>();
    private Map<Integer, TreeSet<Character>> subMap = new HashMap<>();

    public boolean isValidSudoku(char[][] board) {
        int height = board.length;
        int width = board[0].length;
        for (int i = 0; i < height; i++) {
            TreeSet<Character> rowTree = rowMap.getOrDefault(i, new TreeSet<>());
            for (int j = 0; j < width; j++) {
                char c = board[i][j];
                if (rowTree.contains(c)) {
                    return false;
                }
                rowTree.add(c);
                if (!validateIsRepeat(i, j, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validateIsRepeat(int row, int col, char c) {
        if (c < '0' || c > '9') {
            return true;
        }
        TreeSet<Character> colTree = colMap.getOrDefault(col, new TreeSet<>());
        if (colTree.contains(c)) {
            return false;
        }
        colTree.add(c);
        int idx = row / 2 + col / 2;
        TreeSet<Character> subTree = subMap.getOrDefault(idx, new TreeSet<>());
        if (subTree.contains(c)) {
            return false;
        }
        subTree.add(c);
        return true;
    }
}
