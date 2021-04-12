package leetcode.middle;

import java.util.*;

public class LargestNumber_179 {
    public static String largestNumber(int[] nums){
        List<String> numList=new ArrayList<>();
        Arrays.stream(nums).forEach(num->numList.add(num+""));
        Collections.sort(numList,(str1,str2)->  (str2+str1).compareTo(str1+str2) );
        StringBuilder result=new StringBuilder();
        numList.stream().forEach(str->result.append(str));
        return result.toString();
    }
}
