package leetcode.middle;

public class MaxScore_1423 {

    public int maxScore(int[] cardPoints, int k) {
        //sliding window
        int n = cardPoints.length;
        int res = 0;
        for (int i = n - k; i < n; i++) {
            res += cardPoints[i];
        }
        int sum = res;
        for (int i = 0; i < k; i++) {
            sum -= cardPoints[(n - k + i) % n];
            sum += cardPoints[(n + i) % n];
            res = Math.max(res, sum);
        }
        return res;
    }

}
