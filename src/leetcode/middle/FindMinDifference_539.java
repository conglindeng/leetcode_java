package leetcode.middle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FindMinDifference_539 {
    public int findMinDifference(List<String> timePoints) {
        int res = Integer.MAX_VALUE;
        Collections.sort(timePoints);
        int pre = getMinutes(timePoints.get(0));
        for (int i = 1; i < timePoints.size(); i++) {
            int cur = getMinutes(timePoints.get(i));
            res = Math.min(res, cur - pre);
            pre = cur;
        }
        if (getMinutes(timePoints.get(0)) == pre) {
            res = 0;
        } else {
            res = Math.min(res, getMinutes(timePoints.get(0)) - pre + 1440);
        }
        return res;
    }


    private int getMinutes(String s) {
        return ((s.charAt(0) - '0') * 10 + (s.charAt(1) - '0')) * 60 + (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
    }

}
