package leetcode.middle;

public class CustomSortString_791 {
    public static String customSortString(String S,String T){
        char[] schars = S.toCharArray();
        String result="";
        int[] count=new int[26];

        char[] tchars = T.toCharArray();
        for (int i = 0; i < tchars.length; i++) {
            count[tchars[i]-'a']++;
        }


        for (int i = 0; i < schars.length; i++) {
            count[schars[i]-'a']--;
            if(count[schars[i]-'a']>=0){
                result+=schars[i];
            }
        }
        for (int i = 0; i < count.length; i++) {
            int i1 = count[i];
            while(i1>0){
                result+=(char)('a'+i);
                i1--;
            }
        }
        return result;
    }

}
