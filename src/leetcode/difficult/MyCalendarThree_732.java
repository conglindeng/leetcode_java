package leetcode.difficult;

import java.util.Map.Entry;
import java.util.TreeMap;

public class MyCalendarThree_732 {

    TreeMap<Integer, Integer> info;

    public MyCalendarThree_732() {
        info = new TreeMap<>();
    }

    public int book(int start, int end) {
        info.put(start, info.getOrDefault(start, 0) + 1);
        info.put(end, info.getOrDefault(end, 0) - 1);
        int cur = 0;
        int res = -1;
        for (Entry<Integer, Integer> entry : info.entrySet()) {
            cur += entry.getValue();
            res = Math.max(cur, res);
        }
        return res;
    }

}
