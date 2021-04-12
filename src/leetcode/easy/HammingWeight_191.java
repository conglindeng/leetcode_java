package leetcode.easy;

public class HammingWeight_191 {
    public int hammingWeight(int n){
        int result=0;
        for(int i=1;i<=32;i++){
            if((n&(1<<i))==1){
                result++;
            }
        }
        return result;
    }
}
