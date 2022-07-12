package algorithm;

public class KMP {

    /**
     * 暴力解法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int violence(String haystack, String needle) {
        int length1 = haystack.length();
        int length = needle.length();
        if (length == 0 && length1 == 0) {
            return 0;
        }
        if (length > length1) {
            return -1;
        }
        for (int i = 0; i + length <= length1; i++) {
            boolean flag = true;
            for (int i1 = 0; i1 < length; i1++) {
                if (needle.charAt(i1) != haystack.charAt(i1 + i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }


    private int[][] dp;
    private String pattern;

    public KMP(String pattern) {
        this.pattern = pattern;
        dp = new int[pattern.length()][26];
        int x = 0;
        dp[0][(pattern.charAt(0) - 'a')] = 1;
        for (int i = 1; i < pattern.length(); i++) {
            int c = pattern.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                dp[i][j] = dp[x][j];
            }
            dp[i][c] = i + 1;
            x = dp[x][c];
        }
    }

    public int search(String source) {
        int patternLength = pattern.length();
        int length = source.length();
        int n = 0;
        for (int i = 0; i < length; i++) {
            n = dp[n][source.charAt(i) - 'a'];
            if (n == patternLength) {
                return i - patternLength + 1;
            }
        }
        return -1;
    }
}
