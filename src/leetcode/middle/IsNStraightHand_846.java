package leetcode.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsNStraightHand_846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand == null || hand.length == 0) {
            return false;
        }
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> count = new HashMap<>();
        for (int j : hand) {
            count.put(j, count.getOrDefault(j, 0) + 1);
        }
        for (int i : hand) {
            if (!count.containsKey(i)) {
                continue;
            }
            Integer c = count.get(i);
            for (int j = 0; j < groupSize; j++) {
                int cur = i + j;
                if (count.getOrDefault(cur, 0) < c) {
                    return false;
                }
                count.put(cur, count.get(cur) - c);
                if (count.get(cur) == 0) {
                    count.remove(cur);
                }
            }
        }
        return true;
    }
}
