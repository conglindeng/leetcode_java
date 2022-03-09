package leetcode.easy;

import java.util.Arrays;

public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        //1.mapCount  时间空间都为o(n)
        //2.排序 时间：nlogn
        //3.
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
