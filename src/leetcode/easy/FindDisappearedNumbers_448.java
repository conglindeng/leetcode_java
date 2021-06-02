package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers_448 {
    public static List<Integer> findDisappearedNumbers(int[] nums){
        int n=nums.length;
        List<Integer> result=new ArrayList<>();
        for (int num : nums) {
            int x=(num-1)%n;
            nums[x]+=n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                result.add(i+1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{1,2,3,2,1}));
    }
}
