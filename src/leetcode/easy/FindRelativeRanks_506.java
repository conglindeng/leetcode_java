package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRelativeRanks_506 {
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            indexMap.put(score[i], i);
        }
        Arrays.sort(score);
        String[] res = new String[score.length];
        for (int n = score.length - 1; n >= 0; n--) {
            Integer index = indexMap.get(score[n]);
            if (score.length == n + 1) {
                res[index] = "Gold Medal";
            } else if (score.length == n + 2) {
                res[index] = "Silver Medal";
            } else if (score.length == n + 3) {
                res[index] = "Bronze Medal";
            } else {
                res[index] = String.valueOf(score.length - n);
            }

        }
        return res;
    }
}
