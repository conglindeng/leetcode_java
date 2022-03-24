package leetcode.difficult;

public class FindKthNumber_440 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(cur, n);
            if (steps <= k) {
                k -= steps;
                cur++;
            } else {
                k--;
                cur *= 10;
            }
        }
        return cur;
    }

    private int getSteps(int cur, long n) {
        int steps = 0;
        long start = cur;
        long end = cur;
        while (start <= n) {
            steps += Math.min(n, end) - start + 1;
            start *= 10;
            end = end * 10 + 9;
        }
        return steps;
    }
}
