package leetcode.easy;

public class NumWaterBottles_1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) {
            return numBottles;
        }
        return doNumWaterBottles(numBottles, 0, numExchange);
    }

    private int doNumWaterBottles(int numBottles, int emptyBottles, int numExchange) {
        int allEmpty = numBottles + emptyBottles;
        if (allEmpty < numExchange) {
            return numBottles;
        }
        return numBottles + doNumWaterBottles(allEmpty / numExchange, allEmpty % numExchange, numExchange);
    }
}
