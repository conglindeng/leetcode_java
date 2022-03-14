package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRestaurant_599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> restauranIndex = new HashMap<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            restauranIndex.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            Integer idx = restauranIndex.get(list2[i]);
            if (idx != null) {
                int sum = idx + i;
                if (sum < minSum) {
                    minSum = sum;
                    res = new ArrayList<>();
                    res.add(list2[i]);
                } else if (sum == minSum) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
