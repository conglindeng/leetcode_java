package leetcode.middle;

public class NumDecodings_91 {
    public static int size=0;

    public static int numDecodings(String s) {
        if (s == null || "".equals(s) || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1 && inRange(s)) {
            size++;
        }else{
            dfs(s);
        }
        return size;
    }

    public static void dfs(String c){
        if(c.length()==1){
            if(inRange(c))
                size++;
        }
        else if(c.length()==2){
            if(c.charAt(0)=='0'){
            }else{
                if(inRange(c)){
                    size++;
                }
                if(inRange(c.substring(0,1)) && inRange(c.substring(1,2))){
                    size++;
                }
            }
        }else{
            if("0".equals(c.substring(0,1))){
            }else{
                if(inRange(c.substring(0,2))){
                    dfs(c.substring(2));
                }
                if(inRange(c.substring(0,1))){
                    dfs(c.substring(1));
                }
            }
        }
    }

    public static boolean inRange(String s){
        if(s.startsWith("0"))
            return false;
        int integer = Integer.parseInt(s);
        return integer<=26 && integer>=1;
    }

    public static boolean inRange(char s){
        if('0'==s)
            return false;
        return  s <='9' &&  s >='1';
    }

    public static int numDecodings_new(String s){
        int length = s.length();
        int[] dp=new int[length+1];
        dp[0]=1;
        if(inRange(s.charAt(0))){
            dp[1]=1;
        }
        for (int i = 1; i < length; i++) {
            if(s.charAt(i)!='0'){
                dp[i+1]+=dp[i];
            }
            if(inRange(s.substring(i-1,i+1))){
                dp[i+1]+=dp[i-1];
            }
        }
        return dp[length];
    }

    public static int numDecodings_new_new(String s){
        int length = s.length();
        int[] dp=new int[length+1];
        dp[0]=1;
        for (int i = 0; i < length; i++) {
            if(s.charAt(i)!='0'){
                dp[i+1]+=dp[i];
            }
            if(i>=1 && s.charAt(i-1)!='0' && ((s.charAt(i-1)-'0')*10+(s.charAt(i)-'0')<=26)){
                dp[i+1]+=dp[i-1];
            }
        }
        return dp[length];
    }

}
