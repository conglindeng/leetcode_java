package leetcode.difficult;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AlienOrder_Offer_114
 * @Author conglindeng
 * @Date 2022/5/31 13:22
 * @Version 1.0
 */
public class AlienOrder_Offer_BFS_114 {

    boolean isValid = true;
    Map<Character, List<Character>> edges = new HashMap<>();
    Map<Character, Integer> degree = new HashMap<>();

    public String alienOrder(String[] words) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                edges.putIfAbsent(word.charAt(i), new ArrayList<>());
            }
        }
        for (int i = 1; i < words.length; i++) {
            buildEdge(words[i - 1], words[i]);
        }
        if (!isValid) {
            return "";
        }
        //入度为0的字母
        Deque<Character> work = new LinkedList<>();
        for (Character character : edges.keySet()) {
            if (degree.getOrDefault(character, 0) == 0) {
                work.addLast(character);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!work.isEmpty()) {
            Character poll = work.pollLast();
            res.append(poll);
            List<Character> nexts = edges.get(poll);
            for (Character next : nexts) {
                Integer orDefault = degree.getOrDefault(next, 0);
                if (orDefault >= 1) {
                    degree.put(next, degree.get(next) - 1);
                    if (orDefault == 1) {
                        work.addLast(next);
                    }
                }
            }
        }
        return res.length() < edges.size() ? "" : res.toString();
    }


    private void buildEdge(String before, String after) {
        int i = before.length();
        int j = after.length();
        int m = Math.min(i, j);
        int k = 0;
        for (; k < m; k++) {
            if (before.charAt(k) != after.charAt(k)) {
                char c1 = before.charAt(k);
                char c2 = after.charAt(k);
                edges.get(c1).add(c2);
                degree.put(c2, degree.getOrDefault(c2, 0) + 1);
                break;
            }
        }
        if (k == m && i > j) {
            isValid = false;
        }
    }


}
