package essay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //todo:dcl
        int n = nums.length;
        int i = 0;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 3) {
            return res;
        }
        while (i < n - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            int target = -nums[i];
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            i++;
        }
        return res;
    }
}
