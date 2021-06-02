package leetcode.easy;

import java.util.*;

public class CommonChars_1002 {
    //"bella","label","roller"
    public List<String> commonChars(String[] words){


        int[] count=new int[26];
        Arrays.fill(count,Integer.MAX_VALUE);
        for (String word : words) {
            int[] cur=new int[26];
            for (int i = 0; i < word.length(); i++) {
                cur[word.charAt(i)-'a']++;
            }
            for (int i = 0; i < cur.length; i++) {
                count[i]=Math.min(count[i],cur[i]);
            }
        }
        List<String> result=new ArrayList<>();

        for (int i = 0; i < count.length; i++) {
            if(count[i]==Integer.MAX_VALUE || count[i]==0){
                continue;
            }
            for(int j=0;j<count[i];j++){
                char c = (char)('a' + i);
                result.add(String.valueOf(c));
            }
        }
        return result;
    }

}
