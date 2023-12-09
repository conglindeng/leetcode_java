package leetcode.middle;

import java.util.Arrays;
import java.util.Comparator;

public class MaxTaxiEarnings_2008 {

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(i -> i[1]));
        long[] dp = new long[rides.length + 1];
        for (int i = 0; i < rides.length; i++) {
            int pre = binarySearch(i, rides[i][0], rides);
            dp[i + 1] = Math.max(dp[i], dp[pre] + rides[i][1] - rides[i][0] + rides[i][2]);
        }
        return dp[rides.length];
    }

    private int binarySearch(int right, int target, int[][] rides) {
        int left = 0;
        int mid;
        while (left < right) {
            mid = ((right - left) >> 1) + left;
            if (rides[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
