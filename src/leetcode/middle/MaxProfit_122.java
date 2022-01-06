package leetcode.middle;

public class MaxProfit_122 {
    public int maxProfit(int[] prices) {
        // dp[i][0] 为第i天不持有股票的利润最大值
        // dp[i][1] 为第i天持有一股票的利润最大值
        // 则状态转移方程：
        // dp[i][0]=max(dp[i-1][0],dp[i-1][1]+prices[i])
        //      第i天不持有股票的利润最大值，可能是情况：前一天就已经卖掉即dp[i-1][0]，或者前一天持有股票今天卖掉即dp[i-1][1]+prices[i]
        // dp[i][1]=max()
        //      第i天持有一股票的利润最大值，可能的情况：前一天持有一股票即dp[i-1][1]，或者前一天不持股票今天买入即dp[i-1][0]-prices[i]
        // 边界条件：第一天的无法卖出股票，dp[0][0]的值为0，第一天可以买入股票则dp[0][1]为-prices[0]
        // 最终的结果为dp[n]（n为最后一天）中的两个数之一，由本身的抽象可知，dp[n][0]为卖掉股票的利润，肯定大于dp[n][1]持有一股票的利润，所以最终的结果为dp[n][0]


        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public int maxProfit_Optimize(int[] prices) {
        int dp0 = 0, dp1 = -prices[0];
        for (int price : prices) {
            int temp0 = dp0;
            dp0 = Math.max(temp0, dp1 + price);
            dp1 = Math.max(dp1, temp0 - price);
        }
        return dp0;
    }

    public int maxProfit_Greed(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

}
