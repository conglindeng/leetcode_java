package leetcode.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class LongestWord_720 {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });
        Set<String> set = new TreeSet<>();
        set.add("");
        String res = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                res = word;
            }
        }
        return res;

    }
}
