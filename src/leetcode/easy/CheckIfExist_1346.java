package leetcode.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class CheckIfExist_1346 {
    public boolean checkIfExist(int[] arr){
        Set<Integer> dd=new TreeSet<>();
        int zeroCount=0;
        for (int j : arr) {
            if(j==0){
                zeroCount++;
            }else {
                dd.add(j);
            }
        }
        for (int i : arr) {
            if(dd.contains(i*2)){
                return true;
            }
        }
        if(zeroCount>1){
            return true;
        }
        return false;
    }
}
