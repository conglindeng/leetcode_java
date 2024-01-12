package leetcode.middle;

public class AddMinimum_2645 {

    /**
     * 2645. 构造有效字符串的最少插入数 中等
     * <p>
     * 给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。
     * <p>
     * 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：word = "b" 输出：2 解释：在 "b" 之前插入 "a" ，在 "b" 之后插入 "c" 可以得到有效字符串 "abc" 。 示例 2：
     * <p>
     * 输入：word = "aaa" 输出：6 解释：在每个 "a" 之后依次插入 "b" 和 "c" 可以得到有效字符串 "abcabcabc" 。 示例 3：
     * <p>
     * 输入：word = "abc" 输出：0 解释：word 已经是有效字符串，不需要进行修改。
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * a aa ab ac b ba bb bc c ca cb cc
     * <p>
     * state machine ?
     *
     * @param word
     * @return
     */
    //aaaabb
    public int addMinimum(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'a') {
                if (i == word.length() - 1) {
                    res += 2;
                } else {
                    char next = word.charAt(i + 1);
                    if (next == 'c') {
                        res += 1;
                    } else if (next == 'a') {
                        res += 2;
                    }
                }
            } else if (c == 'b') {
                if (i == 0) {
                    res += 1;
                }
                if (i == word.length() - 1) {
                    res += 1;
                } else {
                    char next = word.charAt(i + 1);
                    if (next == 'a') {
                        res += 1;
                    } else if (next == 'b') {
                        res += 2;
                    }
                }
            } else {
                if (i == 0) {
                    res += 2;
                }
                if (i < word.length() - 1) {
                    char next = word.charAt(i + 1);
                    if (next == 'b') {
                        res += 1;
                    } else if (next == 'c') {
                        res += 2;
                    }
                }
            }
        }
        return res;
    }


    public int addMinimum_dp(String word) {
        int l = word.length();
        int[] dp = new int[l + 1];
        for (int i = 1; i <= l; i++) {
            dp[i] = dp[i - 1] + 2;
            if (i > 1 && word.charAt(i - 1) > word.charAt(i - 2)) {
                dp[i] = dp[i - 1] - 1;
            }
        }
        return dp[l];
    }

    //ac-1
    //cc-2
    public int addMinimum_splice(String word) {
        int res = word.charAt(0) - word.charAt(word.length() - 1) + 2;
        for (int i = 1; i < word.length(); i++) {
            res += (word.charAt(i) - word.charAt(i - 1) + 2) % 3;
        }
        return res;
    }

    public int addMinimum_groupCont(String word) {
        int m = 1;
        int l = word.length();
        for (int i = 1; i < l; i++) {
            if (word.charAt(i) <= word.charAt(i - 1)) {
                m++;
            }
        }
        return m * 3 - l;
    }

}
