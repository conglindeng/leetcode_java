package leetcode.easy;

public class IsPowerOfFour_342 {
    public boolean isPowerOfFour(int n) {
        if(n<0)
            return false;
        int x= n&(-n);
        if(x!=n)
            return false;
        int index=0;
        for(int i=0;i<32;i++){
            if((x&1)==1){
                index=i;
                break;
            }
            x>>>=1;
        }
        return index%2==0;
    }


    public boolean isPowerOfFour_New(int n){
        return n>0 && (n&(n-1))==0 && (n & 0xaaaaaaaa)==0;
    }
}
