package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FindLHS_594 {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> info = new HashMap<>();
        for (int num : nums) {
            info.put(num, info.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int key:info.keySet()) {
            if (info.containsKey(key + 1)) {
                res = Math.max(res, info.get(key + 1) + info.get(key));
            }
        }
        return res;
    }
}
