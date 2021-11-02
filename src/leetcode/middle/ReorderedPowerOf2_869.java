package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class ReorderedPowerOf2_869 {
    boolean[] vis;

    public boolean reorderedPowerOf2(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        vis = new boolean[chars.length];
        StringBuffer sb = new StringBuffer();
        return bfs(sb, chars);
    }

    private boolean bfs(StringBuffer sb, char[] chars) {
        if (sb.length() == chars.length) {
            return is2Power(Integer.parseInt(sb.toString()));
        }
        for (int i = 0; i < chars.length; i++) {
            //三种情况下，不取当前元素，
            // 1.已访问
            // 2.当前已遍历的结果是"0"
            // 3.当前已遍历的结果不是“0”，但当前取的是重复元素
            if (vis[i] || "0".equals(sb.toString()) || (i > 0 && chars[i] == chars[i - 1] && !vis[i - 1])) {
                continue;
            }
            vis[i] = true;
            sb.append(chars[i]);
            boolean bfs = bfs(sb, chars);
            if (bfs) {
                return bfs;
            }
            vis[i] = false;
            if (sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
        }
        return false;
    }

    private boolean is2Power(int n) {
        return Integer.bitCount(n) == 1;
    }
}
