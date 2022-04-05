package leetcode.middle;

public class NumArray_307 {
    int[] nums;
    int[] sums;

    public NumArray_307(int[] nums) {
        this.nums = new int[nums.length];
        this.sums = new int[nums.length + 1];
        System.arraycopy(nums, 0, this.nums, 0, nums.length);
        sums[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public void update(int index, int val) {
        int range = val - nums[index];
        nums[index] = val;
        for (int i = index + 1; i < sums.length; i++) {
            sums[i] += range;
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left + 1];
    }
}
