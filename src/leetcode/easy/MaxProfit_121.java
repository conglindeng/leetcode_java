package leetcode.easy;

public class MaxProfit_121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, res = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            if (price > min) {
                res = Math.max(res, price - min);
            }
        }
        return res;
    }
}
