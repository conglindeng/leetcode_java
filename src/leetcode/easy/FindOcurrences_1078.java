package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindOcurrences_1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        if (words.length < 3) {
            return new String[]{};
        }
        String f = words[0];
        String s = words[1];
        List<String> res = new ArrayList<>();
        for (int i = 2; i < words.length; i++) {
            if (f.equals(first) && s.equals(second)) {
                res.add(words[i]);
            }
            f = words[i - 1];
            s = words[i];
        }
        return res.toArray(new String[0]);
    }

    public String[] findOcurrences_Optimize(String text, String first, String second) {
        String[] words = text.split(" ");
        if (words.length < 3) {
            return new String[]{};
        }
        List<String> res = new ArrayList<>();
        for (int i = 1; i < words.length; i++) {
            if (words[i].equals(second)) {
                if (words[i - 1].equals(first) && i < words.length - 1) {
                    res.add(words[i + 1]);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
