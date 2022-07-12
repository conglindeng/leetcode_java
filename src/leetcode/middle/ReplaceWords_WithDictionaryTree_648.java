package leetcode.middle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords_WithDictionaryTree_648 {
    //输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
    //输出："the cat was rat by the bat"

    private Tire tire = new Tire('-');

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String s : dictionary) {
            Tire temp = this.tire;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                temp.children.putIfAbsent(c, new Tire(c));
                temp = temp.children.get(c);
            }
            temp.children.put('#', new Tire('#'));
        }
        String[] split = sentence.split(" ");
        String[] res = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            res[i] = getRoot(split[i]);
        }
        return String.join(" ", res);
    }

    private String getRoot(String cur) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        Tire temp = this.tire;
        while (i < cur.length()) {
            if (temp.children.containsKey('#')) {
                return res.toString();
            }
            if (!temp.children.containsKey(cur.charAt(i))) {
                return cur;
            }
            temp = temp.children.get(cur.charAt(i));
            res.append(temp.cur);
            i++;
        }
        return res.toString();
    }


    static class Tire {

        private Map<Character, Tire> children;
        private Character cur;

        public Tire(Character cur) {
            this.cur = cur;
            children = new HashMap<>();
        }
    }

}
