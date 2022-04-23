package leetcode.middle;

public class CountVowels_2063 {
    public long countVowels(String word) {
        long res = 0;
        int l = word.length();
        for (int i = 0; i < l; i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
//                if (i == 0 || i == l - 1) {
//                    res += l;
//                } else {
                res += (long) (i + 1) * (l - i);
//                }
            }
        }
        return res;
    }

    public long countVowels_Optimize(String word) {
        //dp[i+1] 表示以i为结尾的所有子字符串中的元音字母的个数
        // 最终答案则为dp[l]
        // 初始dp[0]=0
        // 迭代：如果i处的字符为元音字符，则dp[i+1]=dp[i]+i+1，否则dp[i+1]=dp[i]
        // 最终的结果为dp的累加和
        int l = word.length();
        long dp = 0;
        long sum = 0;
        for (int i = 0; i < l; i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                dp += i + 1;
            }
            sum += dp;
        }
        return sum;
    }
}
