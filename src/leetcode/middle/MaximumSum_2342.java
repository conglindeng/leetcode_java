package leetcode.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MaximumSum_2342 {

    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> groupBySum = new HashMap<>();
        for (int num : nums) {
            int sum = getSum(num);
            groupBySum.putIfAbsent(sum, new ArrayList<>());
            groupBySum.get(sum).add(num);
        }
        int res = -1;
        for (Entry<Integer, List<Integer>> integerListEntry : groupBySum.entrySet()) {
            List<Integer> value = integerListEntry.getValue();
            if (value.size() >= 2) {
                Collections.sort(value);
                int curSum = value.get(value.size() - 1) + value.get(value.size() - 2);
                if (curSum > res) {
                    res = curSum;
                }
            }
        }
        return res;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public int maximumSum_Optimize(int[] nums) {
        Map<Integer, Integer> max = new HashMap<>();
        int res = -1;
        for (int num : nums) {
            int sum = getSum(num);
            if (!max.containsKey(sum)) {
                max.put(sum, num);
            } else {
                res = Math.max(res, max.get(sum) + num);
                max.put(sum, Math.max(num, max.get(sum)));
            }
        }
        return res;
    }
}
