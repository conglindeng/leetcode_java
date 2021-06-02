package algorithm;

public class KMP {
    /**
     * 暴力解法
     * @param haystack
     * @param needle
     * @return
     */
    public static int violence(String haystack, String needle){
        int length1 = haystack.length();
        int length = needle.length();
        if(length==0&&length1==0){
            return 0;
        }
        if(length>length1){
            return -1;
        }
        for (int i = 0; i+length <= length1; i++) {
            boolean flag=true;
            for (int i1 = 0; i1 < length; i1++) {
                if(needle.charAt(i1)!=haystack.charAt(i1+i)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
}
