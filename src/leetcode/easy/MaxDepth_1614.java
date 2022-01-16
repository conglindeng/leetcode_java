package leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

public class MaxDepth_1614 {
    public int maxDepth(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        Deque<Character> work = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(') {
                work.add(aChar);
                res = Math.max(res, work.size());
            } else if (aChar == ')') {
                work.poll();
            }
        }
        return res;
    }


    public int maxDepth_Optimize(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        char[] chars = s.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (aChar == '(') {
                count++;
                res = Math.max(res, count);
            } else if (aChar == ')') {
                count--;
            }
        }
        return res;
    }
}
