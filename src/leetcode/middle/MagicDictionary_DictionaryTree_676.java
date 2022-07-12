package leetcode.middle;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MagicDictionary_DictionaryTree_676 {

    Tire root;


    public MagicDictionary_DictionaryTree_676() {
        //最开始的字符，表示根
        root = new Tire('-');
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            Tire temp = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!temp.next.containsKey(c)) {
                    temp.next.put(c, new Tire(c));
                }
                temp = temp.next.get(c);
            }
            //表示结束
            temp.next.put('#', new Tire('#'));
        }
    }

    public boolean search(String searchWord) {
        return dfs(false, searchWord, 0, root);
    }


    private boolean dfs(boolean changed, String word, int index, Tire temp) {
        if (index == word.length()) {
            return temp.next.containsKey('#') && changed;
        }
        char curChar = word.charAt(index);
        boolean res = false;
        for (Entry<Character, Tire> entry : temp.next.entrySet()) {
            if (entry.getKey() != curChar) {
                if (!changed) {
                    res |= dfs(true, word, index + 1, entry.getValue());
                }
            } else {
                res |= dfs(changed, word, index + 1, entry.getValue());
            }
        }
        return res;
    }


    static class Tire {

        char cur;
        Map<Character, Tire> next;

        public Tire(char cur) {
            this.cur = cur;
            this.next = new HashMap<>();
        }
    }
}