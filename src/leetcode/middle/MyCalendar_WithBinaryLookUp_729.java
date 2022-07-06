package leetcode.middle;

import java.util.Comparator;
import java.util.TreeSet;

public class MyCalendar_WithBinaryLookUp_729 {

    TreeSet<int[]> info;

    public MyCalendar_WithBinaryLookUp_729() {
        info = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
    }

    public boolean book(int start, int end) {
        if (info.isEmpty()) {
            info.add(new int[]{start, end});
            return true;
        }

        int[] temp = new int[]{end, 0};

        int[] celling = info.ceiling(temp);//天平
        int[] floor = (celling == null) ? info.last() : info.lower(celling);
        if (info.first() == celling || floor[1] <= start) {
            info.add(new int[]{start, end});
            return true;
        }
        return false;

    }

}