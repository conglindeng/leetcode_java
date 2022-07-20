package leetcode.difficult;

import java.util.HashMap;
import java.util.Map;

class WordFilter_745 {

    Map<String, Integer> str2Word;

    public WordFilter_745(String[] words) {
        str2Word = new HashMap<>();
        for (int m = 0; m < words.length; m++) {
            String word = words[m];
            int l = word.length();
            for (int i = 1; i <= l; i++) {
                for (int j = 1; j <= l; j++) {
                    str2Word.put(word.substring(0, i) + "#" + word.substring(l - j), m);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return str2Word.getOrDefault(pref + "#" + suff, -1);
    }
}