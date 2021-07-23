package algorithm;

import java.util.*;

public class LCS {

    /**
     * 最长公共子序列
     * 例如：两条随机序列，如 1 3 4 5 5 ，and 2 4 5 5 7 6，则它们的最长公共子序列便是：4 5 5。
     */
    public String longestCommonSequence(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        Deque<Character> work = new LinkedList<>();
        int i = length1 - 1;
        int j = length2 - 1;
        while (i >= 0 && j >= 0) {
            if (str1.charAt(i) == str2.charAt(j)) {
                work.push(str1.charAt(i));
                i--;
                j--;
            } else {
                if (dp[i][j + 1] > dp[i + 1][j]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!work.isEmpty()) {
            res.append(work.poll());
        }
        return res.toString();
    }

    /**
     * 最长公共子串
     * 输入：  "1AB2345CD","12345EF"
     * 返回值： "2345"
     * @param str1
     * @param str2
     * @return
     */
    public String longestCommonSubStr(String str1, String str2) {
        if(str1==null||str2==null){
            return "";
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;
        int[][] dp = new int[length1 + 1][length2 + 1];
        int length = -1;
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                length = Math.max(dp[i + 1][j + 1], length);
            }
        }
        List<String> cols = new ArrayList<>();
        for (int i = length1; i > 0; i--) {
            for (int j = length2; j > 0; j--) {
                if (dp[i][j] == length) {
                    cols.add(str2.substring(j-length,j));
                }
            }
        }
        if(cols!=null && cols.size()>0){
            Collections.sort(cols);
            return cols.get(0);
        }
        return "";
    }
}
