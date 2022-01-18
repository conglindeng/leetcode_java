package leetcode.middle;

import javax.swing.*;
import java.util.*;

public class WordBreak_139 {
    boolean res = false;
    Map<Character, List<String>> info = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        for (String s1 : wordDict) {
            char key = s1.charAt(0);
            info.putIfAbsent(key, new ArrayList<>());
            List<String> orDefault = info.get(key);
            orDefault.add(s1);
        }
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int start) {
        if (start == s.length()) {
            res = true;
            return;
        }
        char c = s.charAt(start);
        List<String> strs = info.get(c);
        if (strs == null || strs.size() == 0) {
            return;
        }
        for (String str : strs) {
            if (res) {
                break;
            }
            int idx = str.length() + start;
            if (idx > s.length()) {
                continue;
            }
            String substring = s.substring(start, idx);
            if (substring.equals(str)) {
                dfs(s, idx);
            }
        }
    }

    public boolean wordBreak_Dynamic(String s, List<String> wordDict) {
        Set<String> words = new TreeSet<>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        //dp[j] 表示 s.substring(0,j)是否能由wordDict中元素组成
        for (int j = 1; j <= length; j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] && words.contains(s.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[length];
    }


}