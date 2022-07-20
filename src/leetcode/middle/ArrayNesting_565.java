package leetcode.middle;


public class ArrayNesting_565 {

    public int arrayNesting(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            while (!vis[i]) {
                vis[i] = true;
                count++;
                i = nums[i];
            }
            res = Math.max(res, count);
        }
        return res;
    }


    public int arrayNesting_optimize(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            while (nums[i] < n) {
                int j = nums[i];
                nums[i] = n;
                count++;
                i = j;
            }
            res = Math.max(res, count);
        }
        return res;
    }

}
