package leetcode.easy;

public class OddCells_1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];
        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((row[i] + col[j]) % 2 != 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
