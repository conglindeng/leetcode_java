package leetcode.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinExtraChar_2707 {

    int res;

    DictionaryTree root;

    static class DictionaryTree {

        Character cur;
        Map<Character, DictionaryTree> next;

        Boolean isEnd;

        public DictionaryTree(Character cur) {
            this.cur = cur;
            this.next = new HashMap<>();
            this.isEnd = false;
        }

        private void buildDictionaryTree(String dic, DictionaryTree cur) {
            for (int i = 0; i < dic.length(); i++) {
                char c = dic.charAt(i);
                if (cur.next.containsKey(c)) {
                    cur = cur.next.get(c);
                } else {
                    DictionaryTree dictionaryTree = new DictionaryTree(c);
                    cur.next.put(c, dictionaryTree);
                    cur = dictionaryTree;
                }
            }
            cur.isEnd = true;
        }
    }

    public int minExtraChar(String s, String[] dictionary) {
/*        res = s.length();
        root = new DictionaryTree('-');
        for (String dic : dictionary) {
            root.buildDictionaryTree(dic, root);
        }*/

        Map<String, Integer> dicCnt = new HashMap<>();
        for (String dic : dictionary) {
            dicCnt.put(dic, dicCnt.getOrDefault(dic, 0) + 1);
        }
        int l = s.length();
        int[] dp = new int[l + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= l; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (dicCnt.containsKey(s.substring(j, i))) {
                    dp[i] = Math.min(dp[j], dp[i]);
                }
            }
        }
        return dp[l];
    }
}
