
import leetcode.middle.NumDecodings_91;
import leetcode.middle.ShortestSeq_17_18;
import sort.ArraySort;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static long[][] arr;

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        int[] test1=new int[]{7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
        int[] test2=new int[]{1,5,9};
        new ShortestSeq_17_18().shortestSeq_new(test1,test2);

    }
}
