package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CountWords_2085 {

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> cnt1 = new HashMap<>();
        Map<String, Integer> cnt2 = new HashMap<>();
        for (String s : words1) {
            cnt1.put(s, cnt1.getOrDefault(s, 0) + 1);
        }
        for (String s : words2) {
            cnt2.put(s, cnt2.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (Entry<String, Integer> entry : cnt1.entrySet()) {
            if (entry.getValue() == 1 && cnt2.getOrDefault(entry.getKey(), 0) == 1) {
                res++;
            }
        }
        return res;
    }
}
