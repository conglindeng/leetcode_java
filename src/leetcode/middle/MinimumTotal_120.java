package leetcode.middle;

import java.util.Arrays;
import java.util.List;

public class MinimumTotal_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // dp[i]=Math.min(dp[i]+val,dp[i-1]+val)
        int res = Integer.MAX_VALUE;
        int size = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[size];
        //Arrays.fill(dp, Integer.MAX_VALUE);
        for (List<Integer> item : triangle) {
            for (int j = item.size() - 1; j >= 0; j--) {
                Integer m = item.get(j);
                if (j == 0) {
                    dp[j] += m;
                } else if (j == item.size() - 1) {
                    dp[j] = dp[j - 1] + m;
                } else {
                    dp[j] = Math.min(dp[j - 1] + m, dp[j] + m);
                }
            }
        }
        for (int i : dp) {
            res = Math.min(res, i);
        }
        return res;
    }
}
