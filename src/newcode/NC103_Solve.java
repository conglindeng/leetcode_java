package newcode;

public class NC103_Solve {
    /**
     * 反转字符串
     *
     * @param str string字符串
     * @return string字符串
     */
    public String solve(String str) {
        // write code here
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        char[] chars = str.toCharArray();
        for (int i = 0; i < length / 2; i++) {
            char left = chars[i];
            chars[i] = chars[length - i - 1];
            chars[length - i - 1] = left;
        }
        return new String(chars);
    }
}
