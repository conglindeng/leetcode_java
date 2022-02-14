package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons_1189 {
    public int maxNumberOfBalloons(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }
        Map<Character, Integer> count = new HashMap<>();
        count.put('b',0);
        count.put('a',0);
        count.put('l',0);
        count.put('o',0);
        count.put('n',0);
        char[] chars = text.toCharArray();
        for (char c : chars) {
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
        }
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            Character key = entry.getKey();
            if (key == 'l' || key == 'o') {
                res = Math.min(res, entry.getValue() / 2);
            } else {
                res = Math.min(res, entry.getValue());
            }
        }
        return res;
    }
}
