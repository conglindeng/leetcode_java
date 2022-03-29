package leetcode.middle;

public class MaxConsecutiveAnswers_2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getMaxLength(answerKey, 'T', k), getMaxLength(answerKey, 'F', k));
    }


    private int getMaxLength(String key, char t, int k) {
        int res = -1;
        int left = 0, right = 0;
        int l = key.length();
        int sum = 0;
        for (; right < l; right++) {
            sum += (key.charAt(right) == t) ? 1 : 0;
            while (sum > k) {
                sum -= (key.charAt(left++) == t) ? 1 : 0;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
