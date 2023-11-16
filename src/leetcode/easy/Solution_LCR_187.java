package leetcode.easy;

public class Solution_LCR_187 {

    public int iceBreakingGame(int num, int target) {
        return f(num, target);
    }

    private int f(int num, int target) {
        if (num == 1) {
            return 0;
        }
        return (f(num - 1, target) + target) % num;
    }
}
