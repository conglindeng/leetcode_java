package leetcode.middle;

public class Rob_213 {
    public static int rob(int[] nums){
        int length = nums.length;
        if(length==1){
            return nums[0];
        }
        int max = Math.max(nums[0], nums[1]);
        if(length==2){
            return max;
        }
        int pre_pre=nums[0];
        int pre= max;
        for(int i=2;i<length;i++){
            int cur=Math.max(nums[i]+pre_pre,pre);
            pre_pre=pre;
            pre=cur;
        }
        return pre;
    }
}
