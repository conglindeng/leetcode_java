package leetcode.easy;

public class NumberOfMatches_1688 {
    public int numberOfMatches(int n) {
        int res = 0;
        while (n != 1) {
            int i = n % 2;
            res += n / 2;
            n = n / 2 + i;
        }
        return res;
    }
}
