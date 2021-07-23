package newcode;

public class NC18_RotateMatrix {
    public int[][] rotateMatrix(int[][] mat, int n) {
        if (mat == null) {
            return null;
        }
        int height = mat.length;
        int width = mat[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][width - j];
                mat[i][width - j] = temp;
            }
        }
        return mat;
    }

}
