package leetcode.middle;

public class MinCost_offer_092 {

    public int minCost(int[][] costs) {
        //dp[3][n+1] 数组,dp[m][i+1] 表示将i的房子，刷成m对应的颜色，前面i个房子所消耗的最小成本。
        //边界条件：dp[m][0] 均为0
        //转移方程： (假设m=2) dp[m][i+1]=Math.min(dp[1][i],dp[3][i])+costs[i][2]

        int l = costs.length;
        int[][] dp = new int[3][l + 1];
        for (int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            for (int j = 0; j < 3; j++) {
                dp[j][i + 1] = getMinCost(i, j, dp, cost[j]);
            }
        }
        return Math.min(dp[1][l], Math.min(dp[0][l], dp[2][l]));
    }

    private int getMinCost(int i, int j, int[][] dp, int cost) {
        if (j == 0) {
            return Math.min(dp[1][i], dp[2][i]) + cost;
        }
        if (j == 2) {
            return Math.min(dp[0][i], dp[1][i]) + cost;
        }
        return Math.min(dp[0][i], dp[2][i]) + cost;
    }
}
