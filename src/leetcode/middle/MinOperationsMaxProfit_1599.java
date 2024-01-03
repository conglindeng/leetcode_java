package leetcode.middle;

public class MinOperationsMaxProfit_1599 {


    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int res = -1;
        int l = customers.length;
        int keptCustomers = 0;
        int happyCustomers = 0;
        int maxProfit = -1;
        for (int i = 0; ; i++) {
            if (i < l) {
                keptCustomers += customers[i];
            }
            if (keptCustomers > 4) {
                happyCustomers += 4;
                keptCustomers -= 4;
            } else {
                happyCustomers += keptCustomers;
                keptCustomers = 0;
            }
            int profit = happyCustomers * boardingCost - (i + 1) * runningCost;
            if (profit > 0 && profit > maxProfit) {
                maxProfit = profit;
                res = i + 1;
            }
            if (i >= l && keptCustomers <= 0) {
                break;
            }
        }
        return res;
    }


}
