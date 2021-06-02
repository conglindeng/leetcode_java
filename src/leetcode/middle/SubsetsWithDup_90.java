package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup_90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> item = new ArrayList<>();
            boolean isDuplicate = true;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    boolean previous = (i & (1 << (j - 1))) == 0;
                    if (j > 0 && previous && (nums[j] == nums[j - 1])) {
                        isDuplicate = false;
                        break;
                    }
                    item.add(nums[j]);
                }
            }
            if (isDuplicate) {
                result.add(item);
            }

        }
        return result;
    }
}
