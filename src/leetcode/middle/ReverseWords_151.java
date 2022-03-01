package leetcode.middle;

public class ReverseWords_151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int m = 0, n = length - 1;
        while (m < n && s.charAt(m) == ' ') {
            ++m;
        }
        while (m < n && s.charAt(n) == ' ') {
            --n;
        }
        //去除将多余的空格
        for (int i = m; i <= n; ++i) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else if (i > 0 && s.charAt(i - 1) != ' ') {
                sb.append(s.charAt(i));
            }
        }
        length = sb.length();
        int l = 0, r = length - 1;
        while (l < r) {
            char c = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, c);
            r--;
            l++;
        }
        //翻转每一个单词
        int left = 0;
        while (left < length) {
            int right = left;
            while (right < length && sb.charAt(right) != ' ') {
                ++right;
            }
            int temp = right - 1;
            while (left < temp) {
                char c = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(temp));
                sb.setCharAt(temp, c);
                left++;
                temp--;
            }
            left = right + 1;
        }
        return sb.toString();
    }
}
