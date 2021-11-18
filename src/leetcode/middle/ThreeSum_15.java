package leetcode.middle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        //先取第一个数，若当前取的和先前取的一样，则继续continue
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int firstNum = nums[i];
            int third = nums.length - 1;

            for (int second = i + 1; second < nums.length; second++) {
                if (second > i + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (third > second && (nums[second] + nums[third]) > -firstNum) {
                    third--;
                }
                if(third<=second){
                    break;
                }
                if (nums[second] + nums[third] == -firstNum) {
                    List<Integer> item = new ArrayList<>(3);
                    item.add(firstNum);
                    item.add(nums[second]);
                    item.add(nums[third]);
                    res.add(item);
                }

            }
        }
        return res;
    }
}
