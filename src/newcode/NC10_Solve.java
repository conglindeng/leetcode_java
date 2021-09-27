package newcode;


import util.StringUtils;

import java.nio.charset.Charset;

public class NC10_Solve {
    /**
     * 以字符串的形式读入两个数字，编写一个函数计算它们的乘积，以字符串形式返回。
     * （字符串长度不大于10000，保证字符串仅由'0'~'9'这10种字符组成）
     * <p>
     * 输入：
     * "11","99"
     * 返回值：
     * "1089"
     * 说明：
     * 11*99=1089
     *
     * @param s string字符串 第一个整数
     * @param t string字符串 第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        // write code here
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        char[] sChats = s.toCharArray();
        char[] tChats = t.toCharArray();
        int sLength = sChats.length;
        int tLength = tChats.length;
        String res = "0";
        for (int i = sLength - 1; i >= 0; i--) {
            int m = sLength - i - 1;
            for (int j = tLength - 1; j >= 0; j--) {
                int n = (sChats[i] - '0') * (tChats[j] - '0');
                res = addToString(res, n, m++);
            }
        }
        return StringUtils.reverse(res);
    }

    /**
     * 将一个数加到一个字符串的j位置上
     *
     * @param num 字符串
     * @param n   数字
     * @param j   位置
     * @return
     */
    private String addToString(String num, int n, int j) {
        char[] chars = num.toCharArray();
        StringBuilder sb = new StringBuilder();
        int length = chars.length;
        if (j >= length) {
            sb.append(num);
            while (n > 0) {
                sb.append(n % 10);
                n = n / 10;
            }
            return sb.toString();
        }
        while (n != 0 && j < length) {
            int digit = (chars[j] - '0') + n; //9+81
            chars[j] = Character.forDigit(digit % 10, 10);
            j++;
            n = digit / 10;
        }
        sb.append(chars);
        while (n > 0) {
            sb.append(n % 10);
            n = n / 10;
        }
        return sb.toString();
    }
}
