package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring_395 {
    public static int longestSubstring(String s,int K){
        int ans=0;
        char[] strs=s.toCharArray();
        Map<Character,Integer> freqs=new HashMap<>();
        for(int right=0;right<strs.length;right++){
            char key=strs[right];
            freqs.merge(key, 1, Integer::sum);
            int left=0;
            Map<Character,Integer> copyInfo=new HashMap<>(freqs);
            while(left<=right){
                if(frequence(copyInfo,K)){
                    ans=Math.max(ans,right-left+1);
                }
                char cur=strs[left];
                Integer curFreq = copyInfo.get(cur);
                if(curFreq==1){
                    copyInfo.remove(cur);
                }else{
                    copyInfo.put(cur,curFreq-1);
                }
                left++;
            }
        }
        return ans;
    }
    public static boolean frequence(Map<Character,Integer> info,int K){
        for(Integer freq:info.values()){
            if(freq-K<0){
                return  false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(longestSubstring("bbaaacbd",3));
    }
}
