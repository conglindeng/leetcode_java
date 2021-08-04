package newcode;

import java.util.Arrays;

public class NC34_UniquePath {
    int res;

    /**
     * 递归写法，时间复杂度不符合要求
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int uniquePaths(int m, int n) {
        // write code here
        res = 0;
        if (m < 0 || n < 0) {
            return 0;
        }
        doFindPath(1, 1, m, n);
        return res;
    }

    private void doFindPath(int left, int top, int right, int buttom) {
        if (left > right) {
            return;
        }
        if (top > buttom) {
            return;
        }
        if (left == right && top == buttom) {
            res++;
        }
        doFindPath(left + 1, top, right, buttom);
        doFindPath(left, top + 1, right, buttom);
    }


    /**
     * 递归写法，时间复杂度不符合要求
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int uniquePaths_Optimize(int m, int n) {
        // write code here

        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[] temp = new int[n + 1];
        Arrays.fill(temp, 1);
        for (int j = 1; j < m; j++) {
            for (int i = 2; i <= n; i++) {
                temp[i] += temp[i - 1];
            }
        }
        return temp[n];
    }

}
