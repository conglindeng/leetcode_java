package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic_205 {
    public boolean isIsomorphic(String s, String t) {
        //字符的种类数相等，且每一种的
        //count[i] 表示数量等于i的字符个数
        if (s.length() != t.length()) {
            return false;
        }
        return extracted(s, t) && extracted(t, s);
    }

    private boolean extracted(String s, String t) {
        int l = s.length();
        Map<Character, Character> relationship = new HashMap<>();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            char m = t.charAt(i);
            if (relationship.containsKey(c)) {
                if (m != relationship.get(c)) {
                    return false;
                }
            } else {
                relationship.put(c, m);
            }
        }
        return true;
    }
}
