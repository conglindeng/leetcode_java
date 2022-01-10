package leetcode.easy;

public class Construct2DArray_2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            //计算横坐标和纵坐标
            res[i / n][i % n] = original[i];
        }
        return res;
    }
}
