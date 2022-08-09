package leetcode.difficult;

import java.util.Arrays;

public class OrderlyQueue_899 {

    public String orderlyQueue(String s, int k) {
        if (s.length() < 2) {
            return s;
        }
        String res = s;
        if (k == 1) {
            for (int i = 0; i < s.length(); i++) {
                String str = s.substring(1) + s.charAt(0);
                if (str.compareTo(res) < 0) {
                    res = str;
                }
                s = str;
            }
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            res = new String(chars);
        }
        return res;
    }
}
