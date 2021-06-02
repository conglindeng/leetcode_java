package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrefixesDivBy5 {
    public static List<Boolean> prefixesDivBy5(int[] A){
        List<Boolean> result=new ArrayList<>();
        int number=0;
        for (int i = 0; i < A.length; i++) {
            number=((number<<1)+A[i])%5;
            result.add(number==0);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A=new int[]{0,1,1,1,1,1};
        for (boolean  f: prefixesDivBy5(A)) {
            System.out.println(f);
        }
    }
}
