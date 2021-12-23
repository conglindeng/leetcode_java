package leetcode.middle;

import java.util.Deque;
import java.util.LinkedList;

public class CanJump_55 {
    boolean res = false;

    //从前完后找，使用递归的话会溢出，但写法应该是正确的
    // ——> 使用栈的数据结构
    public boolean canJump(int[] nums) {
        doCanJump(nums, 0);
        return res;
    }

    private void doCanJump(int[] nums, int curIdx) {
        if (curIdx == nums.length - 1) {
            res = true;
            return;
        }
        int maxSteps = nums[curIdx];
        if (curIdx + maxSteps >= nums.length - 1) {
            res = true;
            return;
        }
        for (int i = 1; i <= maxSteps; i++) {
            doCanJump(nums, curIdx + i);
        }
    }


    public boolean canJump_Optimize(int[] nums) {
        //可以额外用个数组来标志是否处理过了
        Deque<Integer> work = new LinkedList<>();
        boolean[] flag = new boolean[nums.length];
        work.add(0);
        while (!work.isEmpty()) {
            int poll = work.poll();
            if (flag[poll]) {
                continue;
            }
            if (poll >= nums.length - 1) {
                return true;
            }
            for (int i = 1; i <= nums[poll]; i++) {
                if (poll + i >= nums.length - 1) {
                    return true;
                }
                work.add(poll + i);
            }
            flag[poll] = true;
        }
        return false;
    }

    public boolean canJump_Optimize_Again(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int curMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= curMax) {
                curMax = Math.max(curMax, nums[i] + i);
                if (curMax >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
