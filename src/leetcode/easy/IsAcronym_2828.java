package leetcode.easy;

import java.util.List;

public class IsAcronym_2828 {

    public boolean isAcronym(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.charAt(0));
        }
        return sb.toString().equals(s);
    }
}
