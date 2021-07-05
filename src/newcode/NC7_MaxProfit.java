package newcode;

import java.util.Map;

public class NC7_MaxProfit {
    /**
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        // write code here
        if (prices == null || prices.length == 0)
            return 0;
        int res = -1;
        int dp = 0;
        for (int i = 1; i < prices.length; i++) {
            if (dp < 0) {
                dp = prices[i] - prices[i - 1];
            } else {
                dp += prices[i] - prices[i - 1];
            }
            res = Math.max(res, dp);
        }
        return res;
    }
}
