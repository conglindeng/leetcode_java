package leetcode.middle;

import java.util.Arrays;

public class NumberOfWeakCharacters_1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        });
        int res = 0;
        int maxDef = 0;
        for (int[] property : properties) {
            if (property[1] < maxDef) {
                res++;
            } else {
                maxDef = property[1];
            }
        }
        return res;
    }

}
