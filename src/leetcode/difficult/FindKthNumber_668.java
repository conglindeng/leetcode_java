package leetcode.difficult;

/**
 * @ClassName FindKthNumber_668
 * @Author conglindeng
 * @Date 2022/5/18 12:10
 * @Version 1.0
 */
public class FindKthNumber_668 {

    //假设x,


    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        int mid;
        while (left < right) {
            mid = (right - left) / 2 + left;
            int count = mid / n * n;
            for (int i = mid / n + 1; i <= m; i++) {
                count += mid / i;
            }
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
