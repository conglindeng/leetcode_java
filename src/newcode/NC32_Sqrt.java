package newcode;

public class NC32_Sqrt {
    /**
     * @param x int整型
     * @return int整型
     */
    public int sqrt(int x) {
        // write code here
        if (x < 0) {
            return -1;
        }
        double left = 0, right = x / 2d + 1;
        while (left < right) {
            double mid = (right - left) / 2 + left;
            if (mid - left < 0.0001) {
                return (int) mid;
            }
            if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
