package algorithm;

public class StepToStairs {

    /**
     * 走楼梯，每一次只能走1步或者2步，计算走n步所有不同的走法数量
     * @param n
     * @return
     */
    public int getCount(int n){
        if(n==1){
            return 1;
        }
        if(n==2)
            return 2;
        int first=1,second=2;
        for(int i=3;i<=n;i++){
            int temp=second;
            second=first+second;
            first=temp;
        }
        return second;
    }

}
