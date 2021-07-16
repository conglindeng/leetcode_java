package newcode;

public class NC18_RotateMatrix {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        //int k= (int)Math.ceil(n / 2);
        int m = n - 1;
        int k = 2;
        for (int i = 0; i < k; i++) {
            for (int j = i; j < k; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[m - i][j];
                mat[m - i][j] = mat[m - i][m - j];
                mat[m - i][m - j] = mat[i][m - j];
                mat[i][m - j] = temp;
            }
        }
        return mat;
    }
}
