package leetcode.middle;

public class NumSubarrayProductLessThanK_713 {


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int l = nums.length;
        int res = 0, mul = 1;
        int j = 0;
        for (int i = 0; i < l; i++) {
            mul *= nums[i];
            while (j <= i && mul >= k) {
                mul /= nums[j++];
            }            res +=  i - j + 1 ;
        }
        return res;
    }

}
