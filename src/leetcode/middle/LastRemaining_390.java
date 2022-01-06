package leetcode.middle;

public class LastRemaining_390 {
    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        int left = 1, right = n;
        int k = 1, count = n, step = 1;
        while (count > 1) {
            if (k % 2 == 0) {
                left = count % 2 == 0 ? left : left + step;
                right = right - step;
            } else {
                left = left + step;
                right = count % 2 == 0 ? right : right - step;
            }
            count >>= 1;
            step <<= 1;
            k++;
        }
        return left;
    }
}
