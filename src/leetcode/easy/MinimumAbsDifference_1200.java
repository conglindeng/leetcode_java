package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference_1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        //差的绝对值 最小，必然是排序后相邻的两个数的差的绝对值之一
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int cur = Math.abs(arr[i] - arr[i - 1]);
            if (cur < min) {
                res = new ArrayList<>();
                min = cur;
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (cur == min) {
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return res;
    }
}
