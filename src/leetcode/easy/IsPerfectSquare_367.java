package leetcode.easy;

public class IsPerfectSquare_367 {
    public boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }
        int mid = num / 2 + 1;
        for (int i = 1; i <= mid; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
}
