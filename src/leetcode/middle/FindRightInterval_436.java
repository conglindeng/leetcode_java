package leetcode.middle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FfindRightInterval_436
 * @Description TODO
 * @Version 1.0
 */
public class FindRightInterval_436 {

    public int[] findRightInterval(int[][] intervals) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        int l = intervals.length;
        for (int i = 0; i < l; i++) {
            idxMap.put(intervals[i][0], i);
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] res = new int[l];
        for (int i = 0; i < l; i++) {
            if (intervals[i][0] == intervals[i][1]) {
                res[idxMap.get(intervals[i][0])] = idxMap.get(intervals[i][0]);
                continue;
            }
            Integer m = findIdx(intervals[i][1], i, intervals);
            if (m == null) {
                res[idxMap.get(intervals[i][0])] = -1;
            } else {
                res[idxMap.get(intervals[i][0])] = idxMap.get(m);
            }
        }
         return res;
    }

    /**
     * 找第一个大于等于的数
     *
     * @param target
     * @param idx
     * @param intervals
     * @return
     */
    private Integer findIdx(int target, int idx, int[][] intervals) {
        int left = idx, right = intervals.length - 1;
        int mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (intervals[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left >= intervals.length || target > intervals[left][0]) {
            return null;
        }
        return intervals[left][0];
    }
}
