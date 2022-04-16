package leetcode.middle;

public class MinDays_1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int low = Integer.MAX_VALUE, high = -1;
        for (int i : bloomDay) {
            low = Math.min(low, i);
            high = Math.max(high, i);
        }
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int c = 0;
        int s = 0;
        for (int j : bloomDay) {
            if (j <= day) {
                c++;
                if (c == k) {
                    s++;
                    c = 0;
                }
            } else {
                c = 0;
            }
        }
        return s >= m;
    }
}
