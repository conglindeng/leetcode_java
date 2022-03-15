package leetcode.middle;

public class CountMaxOrSubsets_2044 {
    int max = Integer.MIN_VALUE;
    int res = 0;
    int[] nums;

    public int countMaxOrSubsets(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            bfs(nums[i], i + 1, nums);
        }
        return res;
    }

    private void bfs(int cur, int idx, int[] nums) {
        if (cur > max) {
            max = cur;
            res = 1;
        } else if (cur == max) {
            res++;
        }
        if (idx >= nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            int temp = cur | nums[i];
            bfs(temp, i + 1, nums);
        }
        // 1 1 1
        // 1 0 1
        // 0 1 1
        // 0 0 0
    }


    //other way to solve
    public int countMaxOrSubsets_Optimize(int[] nums) {
        this.nums = nums;
        if (nums.length == 1) {
            return 1;
        }
        bfs_optimize(0, 0);
        return res;
    }


    private void bfs_optimize(int cur, int pos) {
        if (pos == nums.length) {
            if (cur > max) {
                max = cur;
                res = 1;
            } else if (cur == max) {
                res++;
            }
            return;
        }
        bfs_optimize(cur | nums[pos], pos + 1);
        bfs_optimize(cur, pos + 1);
    }

}
