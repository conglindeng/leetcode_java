package leetcode.easy;

public class MinCostToMoveChips_1217 {

    public int minCostToMoveChips(int[] position) {
        //奇数
        int oddCount = 0;
        //偶数
        int evenCount = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return Math.min(oddCount, evenCount);
    }
}
