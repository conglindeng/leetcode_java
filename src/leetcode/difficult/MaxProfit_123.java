package leetcode.difficult;

public class MaxProfit_123 {
    public int maxProfit(int[] prices) {
        //op1 表示进行一次买操作的最大利润，
        //op2 表示进行了一次买操作和卖操作的最大利润
        //op3 表示完成了一次交易后再做一次买操作的最大利润，
        //op4 表示完成两次交易的最大利润
        int op1 = -prices[0], op2 = 0, op3 = -prices[0], op4 = 0;
        for (int price : prices) {
            op1 = Math.max(-price, op1);
            op2 = Math.max(op2, op1 + price);
            op3 = Math.max(op3, op2 - price);
            op4 = Math.max(op4, op3 + price);
        }
        return op4;
    }

}
