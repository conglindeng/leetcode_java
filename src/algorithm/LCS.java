package algorithm;

public class LCS {
    public String longestCommonSequence(String s1,String s2){
        int length1=s1.length();
        int length2=s2.length();

        int[][] dp=new int[length1+1][length2+1];

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else{
                    dp[i+1][j+1]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        for (int i = length1; i >=1 ; i--) {
            for (int j = length2; j >=1 ; j--) {


            }
        }
        return "";
    }
}
