package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern_290 {

    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char c = pattern.charAt(i);
            if (map.get(c) == null && map2.get(str) == null) {
                map.put(c, str);
                map2.put(str, c);
            } else if (!Objects.equals(str, map.get(c)) || !Objects.equals(c, map2.get(str))) {
                return false;
            }
        }
        return true;
    }
}
