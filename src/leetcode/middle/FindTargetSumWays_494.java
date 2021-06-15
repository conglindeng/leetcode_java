package leetcode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindTargetSumWays_494 {
    int result = 0;
    int target;
    int[] nums;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        dfs(-1, 0);
        return result;
    }

    private void dfs(int index, int sum) {
        if (index == nums.length - 1) {
            result += sum == target ? 1 : 0;
            return;
        }
        index++;
        dfs(index, sum + nums[index]);
        dfs(index, sum - nums[index]);
    }


    public int findTargetSumWays_New(int[] nums, int target) {
        return 0;
    }


}
