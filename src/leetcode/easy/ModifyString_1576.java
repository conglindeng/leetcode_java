package leetcode.easy;

public class ModifyString_1576 {
    public String modifyString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '?') {
                char before = i > 0 ? sb.charAt(sb.length() - 1) : 'a';
                char after = i < s.length() - 1 ? s.charAt(i + 1) : 'z';
                sb.append(getCandidateChar(before, after));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private char getCandidateChar(char first, char second) {
        int i = 0;
        while (true) {
            char m = (char) (i % 26 + 'a');
            if (m != first && m != second) {
                return m;
            }
            i++;
        }
    }
}
