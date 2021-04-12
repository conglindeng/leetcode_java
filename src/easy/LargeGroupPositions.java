package easy;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {
    public static List<List<Integer>> getLargeGroupPositions(String s){
        List<List<Integer>> result=new ArrayList<>();
        int length = s.length();
        if(length<3){
            return result;
        }
        int left=0;
        int i = 1;
        for (; i < length-1; i++) {
            if(s.charAt(i)!=s.charAt(i-1)){
                if(i-left>=3){
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(left);
                    integers.add(i-1);
                    result.add(integers);
                }
                left=i;
            }
        }
        if (s.charAt(i) == s.charAt(i - 1) && i - left >= 2) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(left);
            integers.add(i);
            result.add(integers);
        }
        return result;
    }
}
