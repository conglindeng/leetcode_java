package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbers_1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int width = matrix[0].length;
        int height = matrix.length;
        int[] max = new int[width];
        Arrays.fill(max, Integer.MIN_VALUE);
        int[] min = new int[height];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                min[i] = Math.min(min[j], matrix[i][j]);
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }
        for (int i : max) {
            for (int j : min) {
                if (i == j) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
