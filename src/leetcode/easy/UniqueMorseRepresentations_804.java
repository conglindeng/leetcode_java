package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations_804 {
    private static final String[] code = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {

        Set<String> w = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(code[word.charAt(i) - 'a']);
            }

            w.add(sb.toString());
        }
        return w.size();
    }
}
