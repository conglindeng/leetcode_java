package leetcode.easy;

public class MinStartValue_1413 {

    //前缀和
    public int minStartValue(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
            min = Math.min(min, prefix[i + 1]);
        }
        return min > 0 ? min : Math.abs(min) + 1;
    }
}
