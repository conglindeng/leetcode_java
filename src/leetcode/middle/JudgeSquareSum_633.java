package leetcode.middle;

public class JudgeSquareSum_633 {
    public static boolean judgeSquareSum(int c){
        for (int i = 0; i * i < c; i++) {
            double sqrt = Math.sqrt(c - i * i);
            if(sqrt==(int)sqrt){
                return true;
            }
        }
        return false;
    }

    public static boolean judgeSquareSum_new(int c){
        int left=0,right=(int)Math.sqrt(c);
        while(left<right){
            int cur= left*left+right*right;
            if(cur==c){
                return true;
            }else if(cur<c){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}

