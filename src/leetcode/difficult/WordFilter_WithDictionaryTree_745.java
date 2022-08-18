package leetcode.difficult;

import java.util.HashMap;
import java.util.Map;

public class WordFilter_WithDictionaryTree_745 {

    private static final String end = "##";

    Tire root;

    public WordFilter_WithDictionaryTree_745(String[] words) {
        root = new Tire();
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            int l = word.length();
            Tire cur = root;
            for (int i = 0; i < l; i++) {
                Tire temp = cur;
                for (int j = i; j < l; j++) {
                    String key = "#" + word.charAt(j);
                    if (!temp.next.containsKey(key)) {
                        temp.next.put(key, new Tire());
                    }
                    temp = temp.next.get(key);
                    temp.weight.put(end, index);
                }
                temp = cur;
                for (int m = i; m < l; m++) {
                    String key = word.charAt(l-m-1) + "#";
                    if (!temp.next.containsKey(key)) {
                        temp.next.put(key, new Tire());
                    }
                    temp = temp.next.get(key);
                    temp.weight.put(end, index);
                }
                String key = word.charAt(i) + "" + word.charAt(l - i - 1);
                if (!cur.next.containsKey(key)) {
                    cur.next.put(key, new Tire());
                }
                cur = cur.next.get(key);
                cur.weight.put(end, index);
            }
        }
    }


    public int f(String pref, String suff) {
        int prefLength = pref.length();
        int stuffLength = suff.length();
        int l = Math.max(prefLength, stuffLength);
        Tire temp = root;
        for (int i = 0; i < l; i++) {
            String key = (i >= prefLength ? "#" : pref.charAt(i)) + "" + (i >= stuffLength ? "#"
                : suff.charAt(stuffLength - 1 - i));
            if (!temp.next.containsKey(key)) {
                return -1;
            }
            temp = temp.next.get(key);
        }
        return temp.weight.get(end);
    }


    static class Tire {

        Map<String, Tire> next;
        Map<String, Integer> weight;

        public Tire() {
            this.next = new HashMap<>();
            this.weight = new HashMap<>();
        }

    }
}