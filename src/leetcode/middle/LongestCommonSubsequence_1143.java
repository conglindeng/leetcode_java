package leetcode.middle;

public class LongestCommonSubsequence_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1=text1.length();
        int length2=text2.length();
        int[][] dp=new int[length1+1][length2+1];
        for(int i=1;i<=length1;i++ ){
            char char1 = text1.charAt(i - 1);
            for(int j=1;j<=length2;j++){
                char char2 = text2.charAt(j - 1);
                if(char1==char2){
                    if(dp[i][j-1]==dp[i-1][j]){
                        dp[i][j]=dp[i][j-1]+1;
                    }else{
                        dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                    }
                }
            }

        }


        return dp[length1][length2];
    }
}
