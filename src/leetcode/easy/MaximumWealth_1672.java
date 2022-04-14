package leetcode.easy;

public class MaximumWealth_1672 {
    public int maximumWealth(int[][] accounts) {
        int max = -1;
        for (int[] account : accounts) {
            int curMax = 0;
            for (int i : account) {
                curMax += i;
            }
            max = Math.max(curMax, max);
        }
        return max;
    }
}
