package newcode;

public class NC86_FindElement {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        if (mat == null || mat.length == 0) {
            return new int[0];
        }
        int row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (mat[row][col] == x) {
                return new int[]{row, col};
            } else if (mat[row][col] > x) {
                col--;
            } else {
                row++;
            }
        }
        return new int[0];
    }
}
