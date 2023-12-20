package leetcode.middle;

public class FindPeakGrid_1901 {

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int low = 0;
        int high = m - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int j = 0;
            for (int i = 0; i < n; i++) {
                if (mat[mid][i] > mat[mid][j]) {
                    j = i;
                }
            }
            if (mid > 0 && mat[mid][j] < mat[mid - 1][j]) {
                high = mid - 1;
                continue;
            } else if (mid < m - 1 && mat[mid][j] < mat[mid + 1][j]) {
                low = mid + 1;
                continue;
            }
            return new int[]{mid, j};
        }
        return null;
    }


    private boolean compare(int[][] mat, int i, int j) {
        boolean left = true;
        boolean right = true;
        boolean top = true;
        boolean down = true;
        if (i > 0) {
            top = mat[i][j] > mat[i - 1][j];
        }
        if (i < mat.length - 1) {
            down = mat[i][j] > mat[i + 1][j];
        }
        if (j > 0) {
            left = mat[i][j] > mat[i][j - 1];
        }
        if (j < mat[0].length - 1) {
            right = mat[i][j] > mat[i][j + 1];
        }

        return left && right && top && down;
    }
}
