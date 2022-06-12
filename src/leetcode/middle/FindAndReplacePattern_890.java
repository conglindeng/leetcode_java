package leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern_890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isMatch(pattern, word)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isMatch(String pattern, String target) {
        Map<Character, Character> relation1 = new HashMap<>();
        Map<Character, Character> relation2 = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            char c = pattern.charAt(i);
            char m = target.charAt(i);
            if (relation1.get(c) == null && relation2.get(m) == null) {
                relation1.put(c, m);
                relation2.put(m, c);
            } else if (relation1.get(c) == null || relation2.get(m) == null) {
                return false;
            } else if (relation1.get(c) != m || relation2.get(m) != c) {
                return false;
            }
        }
        return true;
    }
}
