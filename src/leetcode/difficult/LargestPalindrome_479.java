package leetcode.difficult;

public class LargestPalindrome_479 {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int upper = (int) Math.pow(10, n) - 1;
        int ans = 0;
        for (int i = upper; ans == 0; i--) {
            long m = i;
            for (int j = i; j > 0; j = j / 10) {
                m = m * 10 + j % 10;
            }
            for (long j = upper; j * j >= m; j--) {
                if (m % j == 0) {
                    ans = (int) (m % 1337);
                    break;
                }
            }
        }
        return ans;
    }
}
