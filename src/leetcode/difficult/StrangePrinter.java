package leetcode.difficult;

public class StrangePrinter {
    public int strangePrinter(String s){
        int length = s.length();
        int[][] dp=new int[length][length];
        for (int i = length-1; i >=0; i--) {
            dp[i][i]=1;
            for (int j = i+1; j < length; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i][j-1];
                }else{
                    int min=Integer.MIN_VALUE;
                    for(int k=i;k<j;k++){
                        min=Math.min(dp[k+1][j]+dp[i][k],min);
                    }
                    dp[i][j]=min;
                }
            }

        }

        return dp[0][length-1];
    }
}
