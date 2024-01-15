package leetcode.middle;

public class RepeatLimitedString_2182 {


    public String repeatLimitedString(String s, int repeatLimit) {
        int[] charCnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCnt[s.charAt(i) - 'a']++;
        }
        //todo:dcl

        return "";
    }
}
