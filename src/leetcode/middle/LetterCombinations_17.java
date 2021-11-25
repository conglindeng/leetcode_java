package leetcode.middle;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LetterCombinations_17 {

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        getCombinations(digits, 0, new StringBuffer());
        return res;
    }

    private void getCombinations(String digits, int index, StringBuffer sb) {
        if (index == digits.length()) {
            return;
        }
        char v = digits.charAt(index);
        List<Character> chars = getChars(v);
        for (Character aChar : chars) {
            sb.append(aChar);
            if (index == digits.length() - 1) {
                res.add(sb.toString());
            }
            getCombinations(digits, index+1, sb);
            if (sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
        }
    }

    private List<Character> getChars(char digist) {
        List<Character> temp = new ArrayList<>();
        if (digist < '7' && digist > '1') {
            int i = digist - '1';
            for (int j = (i - 1) * 3; j < i * 3; j++) {
                temp.add((char) ('a' + j));
            }
        } else if (digist == '7') {
            temp.add('p');
            temp.add('q');
            temp.add('r');
            temp.add('s');
        } else if (digist == '8') {
            temp.add('t');
            temp.add('u');
            temp.add('v');
        } else if (digist == '9') {
            temp.add('w');
            temp.add('x');
            temp.add('y');
            temp.add('z');
        }
        return temp;
    }
}
