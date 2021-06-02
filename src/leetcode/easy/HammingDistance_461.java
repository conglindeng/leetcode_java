package leetcode.easy;

public class HammingDistance_461 {
    public int hammingDistance(int x,int y){
        int m=x^y;
        int count=0;
        for (int i = 0; i < 32; i++) {
            if((m&1)==1){
                count++;
            }
            m>>>=1;
        }
        return count;
    }
}
