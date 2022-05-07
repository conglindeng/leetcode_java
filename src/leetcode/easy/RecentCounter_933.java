package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class RecentCounter_933 {

    List<Integer> work;

    public RecentCounter_933() {
        work = new ArrayList<>();
    }

    public int ping(int t) {
        work.add(t);
        int cur = work.size() - 1;
        int left = findFirstMoreThanOrEqual(t - 3000);
        return cur - left + 1;
    }

    private int findFirstMoreThanOrEqual(int i) {
        int left = 0, right = work.size() - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (work.get(mid) >= i) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}