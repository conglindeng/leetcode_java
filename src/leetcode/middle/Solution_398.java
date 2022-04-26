package leetcode.middle;

import java.util.*;

public class Solution_398 {
    private Map<Integer, List<Integer>> num2Indexs;
    private Random random;

    public Solution_398(int[] nums) {
        random = new Random();
        num2Indexs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int m = nums[i];
            num2Indexs.putIfAbsent(m, new ArrayList<>());
            num2Indexs.get(m).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> ints = num2Indexs.get(target);
        return ints.get(random.nextInt(ints.size()));
    }
}
