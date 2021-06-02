package leetcode.middle;

public class LongestSubarray_1438 {
    public static int longestSubarray(int[] nums,int limit){
        int result=0;

        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
            min=Math.min(nums[i],min);
            for(int j=0;j<=i;j++){
                max=Math.max(nums[j],max);
                min=Math.min(nums[j],min);
                if(max-min<=limit){
                    result=Math.max(i-j+1,result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{8,2,4,7},4));
    }
}
