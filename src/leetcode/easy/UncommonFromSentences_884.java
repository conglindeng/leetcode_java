package leetcode.easy;

import java.util.*;

public class UncommonFromSentences_884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> allCol = new TreeSet<>();
        Set<String> notDuplicate = new TreeSet<>();
        String[] str1 = s1.split(" ");
        for (String s : str1) {
            if (allCol.contains(s)) {
                notDuplicate.remove(s);
            } else {
                allCol.add(s);
                notDuplicate.add(s);
            }
        }
        String[] str2 = s2.split(" ");
        for (String s : str2) {
            if (allCol.contains(s)) {
                notDuplicate.remove(s);
            } else {
                allCol.add(s);
                notDuplicate.add(s);
            }
        }
        return notDuplicate.toArray(new String[]{});
    }


    public String[] uncommonFromSentences_Optimize(String s1, String s2) {
        Map<String, Integer> freq = new HashMap<String, Integer>();
        insert(s1, freq);
        insert(s2, freq);

        List<String> ans = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                ans.add(entry.getKey());
            }
        }
        return ans.toArray(new String[0]);
    }

    public void insert(String s, Map<String, Integer> freq) {
        String[] arr = s.split(" ");
        for (String word : arr) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
    }
}
