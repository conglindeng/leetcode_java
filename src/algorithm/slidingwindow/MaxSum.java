package algorithm.slidingwindow;

public class MaxSum {

    public static int maxSum(int[] nums,int k ){
        return 0;
    }


    /**
     * 求连续k个数的和的最大值
     * @param nums
     * @param k
     * @return
     */
    public static int maxSum_new(int[] nums,int k ){
        int length = nums.length;
        int[] prefix=new int[length+1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i+1]+=prefix[i];
            prefix[i+1]+=nums[i];
        }
        if(length<=k){
            return prefix[length];
        }
        int result=0;
        for (int i = 3; i < prefix.length; i++) {
            int cur=prefix[i]-prefix[i-3];
            result=Math.max(cur,result);
        }
        return result;
    }
}
