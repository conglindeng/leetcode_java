
import algorithm.DeleteDuplicateNum;
import algorithm.FindMaxKNums;
import algorithm.MaxSubarraySum;
import algorithm.slidingwindow.MaxSum;
import leetcode.middle.*;
import sort.ArraySort;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static long[][] arr;

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        int[] test1=new int[]{7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        int[] test2=new int[]{1,5,9};
        LinkedHashMap<String,String> test=new LinkedHashMap<>();
        test.put("1","1");
        test.put("2","2");
        test.put("3","3");
        System.out.println(new MaxSubarraySum().MaxSubarraySum(new int[]{1, 4, -5, 9, 8, 3, -6}));

    }
}
