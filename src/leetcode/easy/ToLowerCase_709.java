package leetcode.easy;

public class ToLowerCase_709 {
    public String toLowerCase(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                res.append((char) (c + 32));
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
