package leetcode.difficult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName AlienOrder_Offer_114
 * @Author conglindeng
 * @Date 2022/5/31 13:22
 * @Version 1.0
 */
public class AlienOrder_Offer_114 {

    private final int VISITED = 2, VISITING = 1;
    Map<Character, List<Character>> edges = new HashMap<>();
    Map<Character, Integer> status = new HashMap<>();
    boolean isValid = true;
    Set<Character> visited = new HashSet<>();
    int index;
    char[] cs;

    public String alienOrder(String[] words) {
        //所有的char都应该有前后关系
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                edges.putIfAbsent(word.charAt(i), new ArrayList<>());
            }
        }
        for (int i = 1; i < words.length; i++) {
            buildEdge(words[i - 1], words[i]);
        }

        int size = edges.keySet().size();
        cs = new char[size];

        //前后关系都建立了，做拓扑排序
        index = size - 1;
        for (Character character : edges.keySet()) {
            if (!visited.contains(character)) {
                bfs(character);
            }
        }
        if (!isValid) {
            return "";
        }
        return new String(cs);
    }


    private void buildEdge(String before, String after) {
        int l1 = before.length();
        int l2 = after.length();
        int l = Math.min(l1, l2);
        for (int i = 0; i < l; i++) {
            if (before.charAt(i) != after.charAt(i)) {
                edges.get(before.charAt(i)).add(after.charAt(i));
                return;
            }
        }
        if (l2 == l && l < l1) {
            isValid = false;
        }
    }

    private void bfs(char cur) {
        status.put(cur, VISITING);
        List<Character> nextChars = edges.get(cur);
        for (Character m : nextChars) {
            if (!status.containsKey(m)) {
                bfs(m);
                if (!isValid) {
                    return;
                }
            } else if (status.get(m) == VISITING) {
                isValid = false;
                return;
            }
        }
        visited.add(cur);
        status.put(cur, VISITED);
        cs[index--] = cur;
    }

}
