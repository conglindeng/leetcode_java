package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo_731 {

    List<int[]> booked;
    List<int[]> overLaps;


    public MyCalendarTwo_731() {
        booked = new ArrayList<>();
        overLaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] overLap : overLaps) {
            if (end > overLap[0] && start < overLap[1]) {
                return false;
            }
        }
        for (int[] ints : booked) {
            if (end > ints[0] && start < ints[1]) {
                overLaps.add(new int[]{Math.max(ints[0], start), Math.min(ints[1], end)});
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }


}