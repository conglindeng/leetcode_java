package leetcode.easy;

import java.util.Arrays;

public class PivotIndex_724 {
    public static int pivotIndex(int[] nums){
        int sum = Arrays.stream(nums).sum();
        int leftSum=0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * leftSum == sum - nums[i])
                return i;
            leftSum+=nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
