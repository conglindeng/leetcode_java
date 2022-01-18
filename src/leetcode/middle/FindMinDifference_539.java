package leetcode.middle;

import java.util.List;
import java.util.Objects;

public class FindMinDifference_539 {
    public int findMinDifference(List<String> timePoints) {
        int res = Integer.MAX_VALUE;
        //如何量化cpu执行时间
        for (int i = 0; i < timePoints.size(); i++) {
            for (int j = i + 1; j < timePoints.size(); j++) {
                res = Math.min(res, calculateDistance(timePoints.get(i), timePoints.get(j)));
            }
        }
        return res;
    }

    private int calculateDistance(String first, String second) {
        if (first.equals(second)) {
            return 0;
        }
        if ("00:00".equals(first)) {
            return Math.min(doCalculateDistance(first, second), doCalculateDistance("24:00", second));
        }
        if ("00:00".equals(second)) {
            return Math.min(doCalculateDistance(first, second), doCalculateDistance(first, "24:00"));
        }
        return doCalculateDistance(first, second);
    }

    private int doCalculateDistance(String first, String second) {
        int f = getMinutes(first);
        int s = getMinutes(second);
        return Math.abs(f - s);
    }

    private int getMinutes(String s) {
        String[] split = s.split(":");
        int hours = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);
        return hours * 60 + minutes;
    }

}
