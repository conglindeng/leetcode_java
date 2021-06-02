package leetcode.middle;

public class DeleteAndEarn_740 {
    public static int deleteAndEarn(int[] nums){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max=Math.max(max,nums[i]);
        }
        int[] work=new int[max+1];
        for (int num : nums) {
            work[num]+=num;
        }
        return rob(work);
    }

    public static int rob(int[] nums){
        //int[] dp=new int[nums.length];
        int first=nums[0];
        int second=Math.max(nums[0],nums[1]);
        for (int i = 0; i < nums.length; i++) {
            int temp=Math.max(first+nums[i],second);
            first=second;
            second=temp;
        }
        return second;
    }
}
