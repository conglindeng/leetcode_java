package leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

public class MinLength_2696 {

    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("ACDB", "");
            s = s.replace("CABD", "");
            s = s.replace("AB", "");
            s = s.replace("CD", "");
        }
        return s.length();
    }

    public int minLength_Stack(String s) {
        Deque<Character> stack = new LinkedList<>();
        int l = s.length();
        int i = 0;
        while (i < l) {
            char c = s.charAt(i);
            if (stack.size() > 0 && (c == 'D' || c == 'B')) {
                if (c == 'D' && stack.peekLast() == 'C') {
                    stack.pollLast();
                } else if (c == 'B' && stack.peekLast() == 'A') {
                    stack.pollLast();
                } else {
                    stack.addLast(c);
                }
            } else {
                stack.addLast(c);
            }
            i++;
        }
        return stack.size();
    }
}
