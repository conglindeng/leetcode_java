package leetcode.easy;

import java.util.*;

public class MostCommonWord_819 {
    private static char[] Punctuations = new char[]{',', ';', '\'', '.', '!', '?', ' '};

    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> bannedList = Arrays.asList(banned);
        int maxCount = -1;
        Map<String, Integer> count = new HashMap<>();
        int begin = 0, end = 0;
        String res = null;
        while (end < paragraph.length()) {
            char c = paragraph.charAt(end);
            if (getIdx(Punctuations, c) != -1) {
                if (begin != end) {
                    String s = paragraph.substring(begin, end).toLowerCase();
                    if (!bannedList.contains(s)) {
                        count.put(s, count.getOrDefault(s, 0) + 1);
                        if (count.get(s) > maxCount) {
                            maxCount = count.get(s);
                            res = s;
                        }
                    }
                }
                begin = end + 1;
            }
            end++;
        }
        if (begin < end) {
            String s = paragraph.substring(begin, end).toLowerCase();
            if (!bannedList.contains(s)) {
                count.put(s, count.getOrDefault(s, 0) + 1);
                if (count.get(s) > maxCount) {
                    res = s;
                }
            }
        }
        return res;
    }


    private int getIdx(char[] chars, char c) {
        for (int i = 0; i < chars.length; i++) {
            if (c == chars[i]) {
                return i;
            }
        }
        return -1;
    }
}
