package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddToArrayForm_989 {
    public static List<Integer> addToArrayForm(int[] A,int K){
        List<Integer> result=new ArrayList<>();
        int cur=0;
        for(int i=A.length-1;i>=0;i--){
            int first=A[i];
            int second=K%10;

            int curSum=cur+first+second;
            cur=curSum/10;
            result.add(curSum%10);

            K=K/10;
        }
        K=K+cur;
        while(K>0){
            int c=K%10;
            result.add(c);
            K=K/10;
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{2,7,4},181));
    }
}
