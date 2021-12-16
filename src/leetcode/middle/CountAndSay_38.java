package leetcode.middle;

public class CountAndSay_38 {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        String pre = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char[] chars = pre.toCharArray();
        for (int i = 0; i < chars.length; ) {
            char c = chars[i];
            int j = i + 1;
            while (j < chars.length && chars[j] == c) {
                j++;
            }
            sb.append(j - i);
            sb.append(c);
            i = j;
        }
        return sb.toString();
    }
}
