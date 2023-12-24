package leetcode.middle;

public class MinimumPerimeter_1954 {

    public long minimumPerimeter(long neededApples) {
        long left = 1, right = 100000, mid;
        while (left < right) {
            mid = (right - left) / 2 + left;
            if (2 * mid * (mid + 1) * (2 * mid + 1) < neededApples) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left * 4;
    }
}
