package leetcode.easy;

public class Reverse_7 {
    public static int reverse(int x){
        int result=0;
        int cur=x;
        while(cur!=0){
            if(result*10<Integer.MIN_VALUE||result*10>Integer.MAX_VALUE){
                return 0;
            }
            result=result*10+cur%10;
            cur=cur/10;
        }
        return result;
    }
}
