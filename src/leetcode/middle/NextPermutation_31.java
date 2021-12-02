package leetcode.middle;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        //从后往前找，找到第一个nums[i]>nums[i-1]并进行交换
        for (int j = nums.length - 1; j > 0; j--) {
            if (nums[j] > nums[j - 1]) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                return;
            }
        }
        for (int i = 0; i <= (nums.length - 1) / 2; i++) {
            int right = nums.length - 1 - i;
            int temp=nums[right];
            nums[right]=nums[i];
            nums[i]=temp;
        }
    }
}
