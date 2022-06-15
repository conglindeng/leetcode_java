package leetcode.middle;

public class FindDiagonalOrder_498 {

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 1) {
            return mat[0];
        }
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int idx = 0;
        for (int i = 0; ; i++) {
            int colLeft = findColLeft(i, m, n);
            if(colLeft>n-1){
                break;
            }
            int colRight = findColRight(i, m, n);
            if (i % 2 == 0) {
                //斜向上
                for (int j = colLeft; j <= colRight; j++) {
                    res[idx++] = mat[i - j][j];
                }
            } else {
                //斜向下
                for (int j = colRight; j >= colLeft; j--) {
                    res[idx++] = mat[i - j][j];
                }
            }
        }
        return res;
    }

    //如果是正方形的话总是从(k,i-k)到(i-l,l)
    //当前如果是长方形的话，

    private int findColLeft(int i, int m, int n) {
        if (i > m - 1) {
            return i - m + 1;
        }
        return 0;
    }

    private int findColRight(int i, int m, int n) {
        if (i > n - 1) {
            return n - 1;
        }
        return i;
    }

}
