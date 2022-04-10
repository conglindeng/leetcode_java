package leetcode.middle;

public class NumArray_Tree_307 {

    int[] nums;
    int[] sums;
    int l;

    public NumArray_Tree_307(int[] nums) {
        l = nums.length;
        this.nums = nums;
        this.sums = new int[l + 1];
        for (int i = 0; i < l; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return getPrefixSum(right + 1) - getPrefixSum(left);
    }

    private int getLowBit(int index) {
        return index & -index;
    }

    private void add(int index, int val) {
        while (index <= l) {
            sums[index] += val;
            index += getLowBit(index);
        }
    }

    private int getPrefixSum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += sums[index];
            index -= getLowBit(index);
        }
        return sum;
    }
}
