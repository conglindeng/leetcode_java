package leetcode.middle;

public class ContainsNearbyAlmostDuplicate_220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums ,int k,int t){
        //int[] prefix=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //prefix[i]=prefix[i-1]+Math.abs(nums[i]-nums[i-1]);
            for (int j = i+1; j < nums.length ; j++) {
                long a = nums[i] - nums[j];
                if(Math.abs(a)>=t&&Math.abs(i-j)<=k)
                    return true;
            }
        }
        return false;
    }
}
