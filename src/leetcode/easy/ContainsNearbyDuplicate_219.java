package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> info = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (info.containsKey(nums[i])) {
                if ((i - info.get(nums[i])) <= k) {
                    return true;
                }
            }
            info.put(nums[i], i);
        }
        return false;
    }
}
