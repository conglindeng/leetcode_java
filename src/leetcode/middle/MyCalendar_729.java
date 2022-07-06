package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar_729 {

    List<int[]> info;

    public MyCalendar_729() {
        info = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] ints : info) {
            if (start < ints[1] && end > ints[0]) {
                return false;
            }
        }
        info.add(new int[]{start, end});
        return true;
    }

}