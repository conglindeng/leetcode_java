package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class Combine_77 {
    public List<List<Integer>> combine(int n,int k){
        if(k>=n){

        }
        return null;
    }

    private List<Integer> doCombine(int n,int k){
        List<Integer> result=new ArrayList<>();
        if(n==k){
            for (int i = 1; i <= n; i++) {
                result.add(i);
            }
            return result;
        }
        return null;
    }
}
