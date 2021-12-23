package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int height = intervals.length;
        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> res = new ArrayList<>();

        for (int i = 1; i < height; i++) {
            int first = intervals[i][0];
            int second = intervals[i][1];
            if (first >= left && first <= right) {
                right = Math.max(second, right);
            } else {
                res.add(new int[]{left, right});
                left = first;
                right = second;
            }
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[0][0]);
    }
}
