package leetcode.easy;

public class TruncateSentence_1816 {
    /**
     * 输入：s = "Hello how are you Contestant", k = 4
     * 输出："Hello how are you"
     * 解释：
     * s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
     * 前 4 个单词为 ["Hello", "how", "are", "you"]
     * 因此，应当返回 "Hello how are you"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/truncate-sentence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param k
     * @return
     */
    public String truncateSentence(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        if (k == 0) {
            return s;
        }
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        int index = 0;
        while (k > 0 && index < chars.length) {
            sb.append(chars[index]);
            if (chars[index] == ' ') {
                k--;
            }
            index++;
        }
        if (k == 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
