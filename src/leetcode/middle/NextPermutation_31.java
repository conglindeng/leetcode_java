package leetcode.middle;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        for (int length = nums.length - 1; length >= 0; length--) {

        }

    }

    private void reverse(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        for (int i = start; i < mid; i++) {
            swap(nums, i, end - i + start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
