package leetcode.middle;

public class NumArray_Sagment_307 {

    int[] nums;
    int[] sums;
    int n;

    public NumArray_Sagment_307(int[] nums) {
        int l = nums.length;
        for (int i = 1; i <= l; i++) {
            if (i * i == l) {
                n = i;
                break;
            } else if (i * i > l) {
                n = i - 1;
                break;
            }
        }
        this.nums = new int[l];
        int m = (l + n - 1) / n;
        this.sums = new int[m];
        for (int i = 0; i < l; i++) {
            this.nums[i] = nums[i];
            this.sums[i / n] += nums[i];
        }

    }

    public void update(int index, int val) {
        sums[index / n] += val - nums[index];
        nums[index] = val;

    }

    public int sumRange(int left, int right) {
        int sum = 0;
        int i = left / n;
        int j = right / n;
        for (int k = i * n; k < left; k++) {
            sum -= nums[k];
        }
        for (int m = i; m < j; m++) {
            sum += sums[m];
        }
        for (int k = j * n; k <= right; k++) {
            sum += nums[k];
        }
        return sum;
    }
}
