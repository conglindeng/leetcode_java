package leetcode.middle;

import java.util.Deque;
import java.util.LinkedList;

public class MinSwaps_1963 {
    /**
     * 给你一个字符串 s ，下标从 0 开始 ，且长度为偶数 n 。字符串 恰好 由 n / 2 个开括号 '[' 和 n / 2 个闭括号 ']' 组成。
     * <p>
     * 只有能满足下述所有条件的字符串才能称为 平衡字符串 ：
     * <p>
     * 字符串是一个空字符串，或者
     * 字符串可以记作 AB ，其中 A 和 B 都是 平衡字符串 ，或者
     * 字符串可以写成 [C] ，其中 C 是一个 平衡字符串 。
     * 你可以交换 任意 两个下标所对应的括号 任意 次数。
     * <p>
     * 返回使 s 变成 平衡字符串 所需要的 最小 交换次数。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "][]["
     * 输出：1
     * 解释：交换下标 0 和下标 3 对应的括号，可以使字符串变成平衡字符串。
     * 最终字符串变成 "[[]]"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-number-of-swaps-to-make-the-string-balanced
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int minSwaps(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Deque<Character> work = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == ']' && !work.isEmpty() && work.peek() == '[') {
                work.poll();
            } else {
                work.push(curChar);
            }
        }
        int size = work.size();
        return (size + 2) / 4;
    }
}
