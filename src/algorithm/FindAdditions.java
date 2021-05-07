package algorithm;

import java.util.ArrayList;
import java.util.List;

public class FindAdditions {
    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可
     * @param nums
     * @param target
     * @return
     */
    public List<Integer> findAdditions(int[] nums,int target){
        int left=0,right=nums.length-1;
        List<Integer> result=new ArrayList<>();
        while(left<right){
            if(nums[left]+nums[right]>target){
                right--;
            }else if(nums[left]+nums[right]<target){
                left++;
            }else{
                result.add(nums[left]);
                result.add(nums[right]);
                break;
            }

        }
        return result;
    }
}
