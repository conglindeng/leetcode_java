package leetcode.easy;

/**
 * @ClassName: MaxScore_1422
 * @author: conglindeng
 * @Date 2022/8/14
 * @Description
 */
public class MaxScore_1422 {

    public int maxScore(String s) {
        int[] zeroCount = new int[s.length() + 1];
        int[] oneCount = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            zeroCount[i + 1] = zeroCount[i];
            if (s.charAt(i) == '0') {
                zeroCount[i + 1] += 1;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            oneCount[i] = oneCount[i + 1];
            if (s.charAt(i) == '1') {
                oneCount[i] += 1;
            }
        }
        int res = 0;
        for (int i = 1; i <= s.length() - 1; i++) {
            int cur = zeroCount[i] + oneCount[i];
            res = Math.max(res, cur);
        }
        return res;
    }
}
