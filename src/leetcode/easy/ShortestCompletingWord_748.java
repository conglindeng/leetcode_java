package leetcode.easy;

public class ShortestCompletingWord_748 {

    /**
     * 给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
     * <p>
     * 补全词 是一个包含 licensePlate 中所有的字母的单词。在所有补全词中，最短的那个就是 最短补全词 。
     * <p>
     * 在匹配 licensePlate 中的字母时：
     * <p>
     * 忽略 licensePlate 中的 数字和空格 。
     * 不区分大小写。
     * 如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
     * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shortest-completing-word
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param licensePlate
     * @param words
     * @return
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] originCount = getCharCount(licensePlate);
        String res = null;
        for (String word : words) {
            int[] cur = getCharCount(word);
            if (contain(cur, originCount)) {
                if (res == null) {
                    res = word;
                } else if (res.length() > word.length()) {
                    res = word;
                }
            }
        }
        return res;
    }

    private boolean contain(int[] cur, int[] target) {
        for (int i = 0; i < 26; i++) {
            if (target[i] > cur[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] getCharCount(String word) {
        int[] res = new int[26];
        if (word == null || word.length() == 0) {
            return res;
        }
        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                res[c + 32 - 'a'] += 1;
            } else if (c <= 'z' && c >= 'a') {
                res[c - 'a'] += 1;
            }
        }
        return res;
    }

}
