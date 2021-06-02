package leetcode.easy;

public class RemoveDuplicates_26 {
    public static int removeDuplicates(int[] nums){
        int newLength=nums.length;
        if(newLength<=1){
            return newLength;
        }
        for (int i = 1; i < newLength; i++) {
            if(nums[i-1]==nums[i]){
                for (int j = i+1; j < newLength; j++) {
                    nums[j-1]=nums[j];
                }
                newLength--;
                i--;
            }
        }
        return newLength;
    }

    //duoble pointer
    public static int removeDuplicates_new(int[] nums){
        if(nums.length<=1){
            return nums.length;
        }
        int fast=1,slow=1;
        while(fast<nums.length) {
            if(nums[fast-1]!=nums[fast]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
