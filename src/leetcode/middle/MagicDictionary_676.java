package leetcode.middle;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagicDictionary_676 {

    Map<Integer, List<String>> length2Strs;

    public MagicDictionary_676() {
        length2Strs = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            int length = s.length();
            length2Strs.putIfAbsent(length, new ArrayList<>());
            length2Strs.get(length).add(s);
        }
    }

    public boolean search(String searchWord) {
        if (!length2Strs.containsKey(searchWord.length())) {
            return false;
        }
        List<String> strings = length2Strs.get(searchWord.length());
        for (String string : strings) {
            if (differenceOnlyOne(string, searchWord)) {
                return true;
            }
        }
        return false;
    }


    private boolean differenceOnlyOne(String one, String second) {
        int count = 0;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) != second.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

}