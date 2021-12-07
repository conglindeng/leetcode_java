package leetcode.middle;

import java.util.*;

public class FindAnagrams_438 {
    public List<Integer> findAnagrams(String s, String p) {
        HashSet<Character> charSet = new HashSet<>();
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        int length = p.length();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            charSet.add(c);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - length; i++) {
            if (charSet.contains(s.charAt(i))) {
                int j = i;
                //开始判断是否是排列字串
                for (; j < i + p.length(); j++) {
                    char key = s.charAt(j);
                    if (!charSet.contains(key) || charCountMap.get(key) == 0) {
                        break;
                    } else {
                        charCountMap.put(key, charCountMap.get(key) - 1);
                    }
                }
                //循环完，可能两种情况：
                //1.匹配，则将i put到结果中
                //2.不匹配，则什么都不用做
                //3.恢复现场，从j向i遍历，将每个字符放回到charcountmap中
                if (j == i + length) {
                    res.add(i);
                }
                for (int m = j - 1; m >= i; m--) {
                    char key = s.charAt(m);
                    charCountMap.put(key, charCountMap.get(key) + 1);
                }
            }
        }
        return res;
    }

    public List<Integer> findAnagrams_Optimize(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || p.length() > s.length()) {
            return res;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[(p.charAt(i) - 'a')]++;
        }
        if(Arrays.equals(sCount,pCount)){
            res.add(0);
        }
        int length = p.length();
        for (int i = 0; i < s.length() - length; i++) {
            sCount[s.charAt(i)-'a']--;
            sCount[s.charAt(i+ length)-'a']++;
            if(Arrays.equals(pCount,sCount)){
                res.add(i+1);
            }
        }
        return res;
    }
}
