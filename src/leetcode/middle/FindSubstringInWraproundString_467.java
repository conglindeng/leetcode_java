package leetcode.middle;

import java.util.Arrays;

/**
 * @ClassName FindSubstringInWraproundString_467
 * @Description TODO
 * @Author conglindeng
 * @Date 2022/5/25 20:31
 * @Version 1.0
 */
public class FindSubstringInWraproundString_467 {

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); i++) {
            if (k > 0 && ((p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1)) {
                k++;
            } else {
                k = 1;
            }
            int m = p.charAt(i) - 'a';
            dp[m] = Math.max(k, dp[m]);
        }
        return Arrays.stream(dp).sum();
    }
}
