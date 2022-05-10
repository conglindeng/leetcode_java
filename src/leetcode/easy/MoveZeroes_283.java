package leetcode.easy;

public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        while (left < nums.length && nums[left] != 0) {
            left++;
        }
        for (int i = left; i < nums.length; i++) {
            if (nums[i] != 0 && left < i) {
                swap(nums, left, i);
                while (left < i && nums[left] != 0) {
                    left++;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public void moveZeroes_Optimize(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

}
