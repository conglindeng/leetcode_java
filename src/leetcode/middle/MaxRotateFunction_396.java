package leetcode.middle;

public class MaxRotateFunction_396 {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int m = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            sum += nums[i];
            m += i * nums[i];
        }
        int res = m;
        for (int i = 1; i < l; i++) {
            m += sum;
            m -= l * nums[l - i];
            res = Math.max(res, m);
        }
        return res;
    }
}
