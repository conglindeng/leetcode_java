package leetcode.easy;

public class RemoveElement_27 {
    public static int removeElement(int[] nums, int val){
        int low=0,fast=0;
        while(fast<nums.length){
            if(nums[fast]!=val){
                nums[low]=nums[fast];
                low++;
            }
            fast++;
        }
        return low;
    }

    public static int removeElement_optimize(int[] nums ,int val ){
        int left=0,right=nums.length;
        while(left<right){
            if(nums[left]==val){
                nums[left]=nums[right-1];
                right--;
            }else{
                left++;
            }
        }
        return left;
    }
}
