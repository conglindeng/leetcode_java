package leetcode.middle;

public class SwapNumbers_16_01 {
    public static int[] swapNumbers(int[] nums){
        nums[0]=nums[1]+nums[0];
        nums[1]=nums[0]-nums[1];
        nums[0]=nums[0]-nums[1];
        return nums;
    }


    public static int[] swapNumbers_1(int[] nums){
        if(nums[0]==nums[1]){
            return nums;
        }
        nums[0]^=nums[1];
        nums[1]^=nums[0];
        nums[0]^=nums[1];
        return nums;
    }

}
