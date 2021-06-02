package leetcode.easy;

public class FindLengthOfLCIS_674 {
    public static int findLengthOfLCIS(int[] nums){
        int maxCount=0;
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                count++;
            }else{
                maxCount = Math.max(maxCount,count+1);
                count=0;
            }
        }
        if(count!=0){
            return Math.max(maxCount,count+1);
        }
        return maxCount;
    }

    public static int findLengthOfLCIS2(int[] nums){
        int result=0;
        int n=nums.length;
        int start=0;
        for (int i = 0; i < n; i++) {
            if(i>0 && nums[i]<=nums[i-1]){
                start=i;
            }
            result=Math.max(result,i-start+1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS2(new int[]{3,3,3,4}));

    }
}
