package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[right] - nums[right - 1] != 1) {
                if (right-1 == left) {
                    res.add(nums[left] + "");
                } else {
                    res.add(nums[left] + "->" + nums[right - 1]);
                }
                left = right;
            }
            right++;
        }
        if (left == nums.length - 1) {
            res.add(nums[left] + "");
        } else {
            res.add(nums[left] + "->" + nums[right - 1]);
        }
        return res;
    }


    //多叉树先序遍历
}
