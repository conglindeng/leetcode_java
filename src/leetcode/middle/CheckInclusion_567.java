package leetcode.middle;

public class CheckInclusion_567 {
    public static boolean checkInclusion(String s1, String s2) {
        char[] maginChars=s1.toCharArray();
        char[] windowChars=s2.toCharArray();

        int[] magin=new int[26];
        int[] window=new int[26];

        for(int i=0;i<maginChars.length;i++){
            magin[maginChars[i]-'a']++;
        }
        int pCount=0;
        for(int i=0;i<26;i++){
            if(magin[i]>0){
                pCount++;
            }
        }

        int left=0;
        int right=0;
        int winCount=0;

        while(right<windowChars.length){
            if(magin[windowChars[right]-'a']>0){
                window[windowChars[right]-'a']++;
                if(window[windowChars[right]-'a']==magin[windowChars[right]-'a']){
                    winCount++;
                }
            }
            right++;
            while(pCount==winCount){
                if(right-left==s1.length()){
                    return true;
                }
                if(magin[windowChars[left]-'a']>0){
                    window[windowChars[left]-'a']--;
                    if(window[windowChars[left]-'a']<magin[windowChars[left]-'a']){
                        winCount--;
                    }
                }
                left++;
            }
        }



        return false;
    }
}
