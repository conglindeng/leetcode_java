package leetcode.middle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        LinkedList<String> work = new LinkedList<>();
        char[] chars = path.toCharArray();
        for (int i = 0; i < chars.length; ) {
            if (chars[i] == '/') {
                i++;
                continue;
            } else {
                StringBuilder sb = new StringBuilder();
                int right = i;
                while (chars[right] != '/') {
                    sb.append(chars[right]);
                    right++;
                }
                String s = sb.toString();
                if (".".equals(s)) {

                } else if ("..".equals(s)) {
                    if (!work.isEmpty()) {
                        work.removeLast();
                    }
                } else {
                    work.addLast(s);
                }
                i = right;
            }

        }
        StringBuilder sb = new StringBuilder("/");
        while (!work.isEmpty()) {
            sb.append(work.removeFirst());
            sb.append("/");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
