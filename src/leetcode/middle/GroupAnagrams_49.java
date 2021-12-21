package leetcode.middle;

import java.util.*;

public class GroupAnagrams_49 {
    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<CharCountArray, List<String>> count2Strs = new HashMap<>();
        for (String str : strs) {
            CharCountArray charCountArray = new CharCountArray(getCharCount(str));
            count2Strs.putIfAbsent(charCountArray, new ArrayList<>());
            count2Strs.get(charCountArray).add(str);
        }
        return new ArrayList<>(count2Strs.values());
    }

    private int[] getCharCount(String str) {
        int[] res = new int[26];
        if (str == null || str.length() == 0) {
            return res;
        }
        for (char c : str.toCharArray()) {
            res[c - 'a'] += 1;
        }
        return res;
    }

    private static class CharCountArray {
        int[] count = new int[26];

        public CharCountArray(int[] count) {
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CharCountArray that = (CharCountArray) o;

            return Arrays.equals(count, that.count);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(count);
        }
    }
}
