package leetcode.easy;

import java.util.*;

public class CanReorderDoubled_954 {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : arr) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        if (count.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        List<Integer> nums = new ArrayList<>(count.keySet());
        nums.sort(Comparator.comparingInt(Math::abs));
        for (Integer i : nums) {
            if (count.get(i) > count.getOrDefault(2 * i, 0)) {
                return false;
            }
            count.put(2 * i, count.getOrDefault(2 * i, 0) - count.get(i));
        }
        return true;
    }
}
