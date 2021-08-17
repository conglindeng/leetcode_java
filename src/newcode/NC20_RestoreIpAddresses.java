package newcode;

import java.util.ArrayList;

public class NC20_RestoreIpAddresses {

    ArrayList<String> res = new ArrayList<>();

    /**
     * @param s string字符串
     * @return string字符串ArrayList
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        doRestoreIp(chars, 0, 4, sb);
        return res;
    }

    public void doRestoreIp(char[] chars, int index, int num, StringBuilder sb) {
        if ((chars.length - index > num * 3) || (chars.length - index) < num) {
            return;
        }
        if (num == 1) {
            int m = 0;
            int count = 0;
            boolean firstIsZero = false;
            for (int i = index; i < chars.length; i++) {
                m = m * 10 + (chars[i] - '0');
                if (count == 0 && m == 0) {
                    firstIsZero = true;
                }
                count++;
            }
            if ((m > 0 && m < 256 && !firstIsZero) || (m == 0 && count > 0)) {
                sb.append(m);
                res.add(sb.toString());
                sb.delete(sb.length() - count, sb.length());
                return;
            }
        }
        int n = 0;
        int count = 0;
        boolean firstIsZero = false;
        for (int i = index; i < chars.length && i < index + 3; i++) {
            n = n * 10 + (chars[i] - '0');
            if (count == 0 && n == 0) {
                firstIsZero = true;
            }
            count++;
            if ((n > 0 && n < 256 && !firstIsZero) || (n == 0 && count == 1)) {
                sb.append(n);
                sb.append('.');
                System.out.println("递归前：" + sb.toString());
                doRestoreIp(chars, i + 1, num - 1, sb);
                System.out.println("递归后：" + sb.toString()+"  count = " +count);
                sb.delete(sb.length() - count - 1, sb.length());
            }
        }
    }
}
