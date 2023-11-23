package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class EntityParser_1410 {

    private static final Map<String, Character> SpecialChars = new HashMap<>();

    static {
        SpecialChars.put("&quot;", '"');
        SpecialChars.put("&apos;", '\'');
        SpecialChars.put("&amp;", '&');
        SpecialChars.put("&gt;", '>');
        SpecialChars.put("&lt;", '<');
        SpecialChars.put("&frasl;", '/');
    }

    public String entityParser(String text) {
        StringBuilder res = new StringBuilder();
        //start by '&', end by ';'
        int length = text.length();
        for (int i = 0; i < length; ) {
            if (text.charAt(i) == '&') {
                int j = i + 1;
                for (; j < length; j++) {
                    if (text.charAt(j) == '&') {
                        res.append(text, i, j);
                        i = j;
                        break;
                    } else if (text.charAt(j) == ';') {
                        //maybe should replace
                        String substring = text.substring(i, j + 1);
                        if (SpecialChars.containsKey(substring)) {
                            res.append(SpecialChars.get(substring));
                        } else {
                            res.append(substring);
                        }
                        i = j + 1;
                        break;
                    }
                }
                if (j == length) {
                    res.append(text, i, length);
                    break;
                }
            } else {
                res.append(text.charAt(i));
                i++;
            }
        }
        return res.toString();
    }


}
