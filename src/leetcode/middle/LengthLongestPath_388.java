package leetcode.middle;

import java.util.Deque;
import java.util.LinkedList;

public class LengthLongestPath_388 {

    public int lengthLongestPath(String input) {
        int l = input.length();
        int depth = 0;
        int pos = 0;
        int res = 0;
        Deque<Integer> lStack = new LinkedList<>();
        while (pos < l) {
            depth = 1;
            // 获取当前文件或者文件夹的深度
            while (pos < l && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }
            // 获取当前文件或者文件夹的长度
            int curL = 0;
            boolean isFile = false;
            while (pos < l && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                pos++;
                curL++;
            }
            pos++;

            while (lStack.size() >= depth) {
                lStack.poll();
            }
            if (!lStack.isEmpty()) {
                curL += lStack.poll();
            }
            if (isFile) {
                res = Math.max(curL, res);
            } else {
                lStack.push(curL);
            }
        }
        return res;
    }
}
