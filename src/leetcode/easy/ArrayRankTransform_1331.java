package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayRankTransform_1331 {

    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> num2Index = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            num2Index.putIfAbsent(arr[i], new ArrayList<>());
            num2Index.get(arr[i]).add(i);
        }
        int[] ints = Arrays.copyOf(arr, arr.length);
        Arrays.sort(ints);
        int order = 0;
        int[] res = new int[arr.length];
        for (int i = 0; i < ints.length; i++) {
            if (i == 0 || ints[i] != ints[i - 1]) {
                order++;
            }
            for (Integer index : num2Index.get(ints[i])) {
                res[index] = order;
            }
        }
        return res;
    }
}
