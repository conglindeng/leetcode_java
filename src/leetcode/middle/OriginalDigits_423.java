package leetcode.middle;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class OriginalDigits_423 {
    private static final String[] numStr = new String[]{
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private final static int[] priority = new int[]{0, 8, 6, 3, 2, 7, 5, 9, 4, 1};

    public String originalDigits(String s) {
        StringBuffer sb = new StringBuffer();
        int[] info = new int[26];
        for (int i = 0; i < s.length(); i++) {
            info[(s.charAt(i) - 'a')]++;
        }
        for (int i : priority) {
            String cur = numStr[i];
            int count = Integer.MAX_VALUE;
            for (char c : cur.toCharArray()) {
                count = Math.min(count, info[c - 'a']);
            }
            for (char c : cur.toCharArray()) {
                info[c - 'a'] -= count;
            }
            while(count-->0){
                sb.append(i);
            }
        }
        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
