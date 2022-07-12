package leetcode.middle;

import java.util.List;

public class ReplaceWords_648 {

    //输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
    //输出："the cat was rat by the bat"
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] split = sentence.split(" ");
        String[] res = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            res[i] = getMinRoot(dictionary, split[i]);
        }
        return String.join(" ", res);
    }

    private String getMinRoot(List<String> dictionary, String cur) {
        int index = -1;
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < dictionary.size(); i++) {
            String s = dictionary.get(i);
            int j = 0;
            if (s.length() > cur.length()) {
                continue;
            }
            for (; j < s.length(); j++) {
                if (s.charAt(j) != cur.charAt(j)) {
                    break;
                }
            }
            if (j == s.length()) {
                //说明匹配了，则需要判定
                if (s.length() < length) {
                    index = i;
                    length = s.length();
                }
            }
        }
        if (index != -1) {
            return dictionary.get(index);
        }
        return cur;
    }




}
