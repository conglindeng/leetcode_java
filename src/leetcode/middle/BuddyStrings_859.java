package leetcode.middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyStrings_859 {
    public boolean buddyStrings(String s, String goal) {
        if (s == null || s.length() < 2) {
            return false;
        }
        if (s.length() != goal.length()) {
            return false;
        }
        int length = s.length();
        List<Integer> notEqual = new ArrayList<>();
        Set<Character> characters = new HashSet<>();
        boolean atLeastTwoTimes=false;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(characters.contains(c)){
                atLeastTwoTimes=true;
            }else{
                characters.add(c);
            }
            if (c != goal.charAt(i)) {
                notEqual.add(i);
            }
        }
        int size = notEqual.size();
        if (size > 2 || size == 1) {
            return false;
        }
        if (size == 2) {
            int i1 = notEqual.get(0);
            int i2 = notEqual.get(1);
            if (s.charAt(i1) != goal.charAt(i2) || s.charAt(i2) != goal.charAt(i1)) {
                return false;
            }
        }
        //size=2的话，则已经符合要求，否则s和goal相等，则判断s中是否有字母出现2次及以上
        return size == 2 || atLeastTwoTimes;
    }

    public boolean buddyStrings_Optimize(String s, String goal) {
        if (s == null || s.length() == 0 || goal == null || goal.length() == 0) {
            return false;
        }
        if (s.length() != goal.length()) {
            return false;
        }
        //如果两个字符串相等，则需要判定是否至少有一个字母出现了2次以上
        if (s.equals(goal)) {
            int[] info = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (info[index] > 0) {
                    return true;
                } else {
                    info[index] += 1;
                }
            }
        } else {
            List<Integer> notEqualIndex = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    notEqualIndex.add(i);
                }
            }
            if(notEqualIndex.size()!=2){
                return false;
            }
            int index0=notEqualIndex.get(0);
            int index1=notEqualIndex.get(1);
            return s.charAt(index1)==goal.charAt(index0)&&s.charAt(index0)==goal.charAt(index1);
        }
        return false;
    }
}
