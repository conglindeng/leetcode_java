package leetcode.middle;

public class IsInterleave_97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length(), length2 = s2.length();
        if (length1 + length2 != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[0][0] = true;
        //转移方程： dp[i][j]=
        //         (dp[i-1][j]&&s1.charAt(i-1)==s3.chartAt(i+j-1))
        //         ||
        //         (dp[i][j-1]&&s2.charAt(j-1)==s3.chartAt(i+j-1))
        //         )
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
                if (j > 0) {
                    dp[i][j] |= dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
            }
        }
        return dp[length1][length2];
    }

    public boolean isInterleave_Optimize(String s1, String s2, String s3) {
        int length1 = s1.length(), length2 = s2.length();
        if (length1 + length2 != s3.length()) {
            return false;
        }
        boolean[] dp = new boolean[length2 + 1];
        dp[0] = true;
        //转移方程： dp[i][j]=
        //         (dp[i-1][j]&&s1.charAt(i-1)==s3.chartAt(i+j-1))
        //         ||
        //         (dp[i][j-1]&&s2.charAt(j-1)==s3.chartAt(i+j-1))
        //         )
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[j] |= s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
                if (j > 0) {
                    dp[j] |= dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
            }
        }
        return dp[length2];
    }
}
