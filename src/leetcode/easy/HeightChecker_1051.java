package leetcode.easy;

import java.util.Arrays;

public class HeightChecker_1051 {

    public int heightChecker(int[] heights) {
        int res = 0;
        int[] temp = Arrays.copyOf(heights, heights.length);
        Arrays.sort(temp);
        for (int i = 0; i < heights.length; i++) {
            if (temp[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }


    public int heightChecker_With_Bucket(int[] heights) {
        int[] buckets = new int[101];
        for (int heigth : heights) {
            buckets[heigth]++;
        }
        int res = 0, idx = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                if (heights[idx] != i) {
                    res++;
                }
                idx++;
            }
        }
        return res;
    }
}
