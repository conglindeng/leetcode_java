package leetcode.middle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Insert_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> res = new ArrayList<>();
        boolean isCover = false;
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!isCover) {
                    res.add(new int[]{left, right});
                    isCover = true;
                }
                res.add(interval);
            } else if (interval[1] < left) {
                res.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!isCover) {
            res.add(new int[]{left, right});
        }
        return res.toArray(new int[0][]);
    }
}
