package leetcode.middle;

public class MaxSatisfied_1052 {
    public static int maxSatisfied(int[] customers, int[] grumpy, int X){
        int length=grumpy.length;
        int sum=0;
        int result=0;
        for(int i=0;i<length;i++){
            if(grumpy[i]==0){
                sum+=customers[i];
            }
        }
        for(int i=X-1;i<length;i++){
            int curSum=sum;
            for(int j=i-X+1;j<=i;j++){
                if(grumpy[j]==1){
                    curSum+=customers[j];
                }
            }
            result=Math.max(curSum,result);
        }
        return  result;
    }

}
