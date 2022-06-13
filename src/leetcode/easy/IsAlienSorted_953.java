package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName IsAlienSorted_953
 * @Author conglindeng
 * @Date 2022/5/17 09:19
 * @Version 1.0
 */
public class IsAlienSorted_953 {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> idx = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            idx.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            String second = words[i];
            String first = words[i - 1];
            if (!compare(first, second, idx)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String first, String second, Map<Character, Integer> idx) {
        int i = 0, j = 0;
        while (i < first.length() && j < second.length()) {
            Integer m = idx.get(first.charAt(i));
            Integer n = idx.get(second.charAt(j));
            if (m > n) {
                return false;
            } else if (m.equals(n)) {
                i++;
                j++;
            } else {
                return true;
            }
        }
        return j <= second.length()&&i==first.length();
    }
}
