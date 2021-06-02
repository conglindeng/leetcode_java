package leetcode.easy;

public class FindMaxConsecutiveOnes_485 {
    public static int findMaxConsecutiveOnes(int[] nums){
        int result=0;
        int length=0;
        for (int i : nums) {
            if (i == 0) {
                result=Math.max(result,length);
                length=0;
            }
            if(i==1){
                length++;
            }
        }
        result=Math.max(length,result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
}
