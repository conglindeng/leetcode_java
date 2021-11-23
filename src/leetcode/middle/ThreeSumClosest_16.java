package leetcode.middle;

import java.util.Arrays;

public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                //在j后二分查找第一个大于target-first-second 数的index，
                // 再将该index和index-1的数进行判定是否有更小的数
                int sum = nums[i] + nums[j];
                int index = getIndexFromNums(i + 2, nums.length - 1, nums, target - sum);
                int curDistance;
                int curNum;
                if (index == (i + 2)) {
                    curDistance = calucateDistance(target, sum + nums[index]);
                    curNum = nums[index];
                } else if (index == nums.length) {
                    curDistance = calucateDistance(target, sum + nums[index - 1]);
                    curNum = nums[index - 1];
                } else {
                    int f = calucateDistance(target, sum + nums[index]);
                    int s = calucateDistance(target, sum + nums[index - 1]);
                    if (f < s) {
                        curDistance = f;
                        curNum = nums[index];
                    } else {
                        curDistance = s;
                        curNum = nums[index - 1];
                    }
                }
                if (curDistance < distance) {
                    distance = curDistance;
                    res = sum + curNum;
                }
            }
        }
        return res;
    }

    private int calucateDistance(int first, int second) {
        if ((first >= 0 && second >= 0) || (first <= 0 && second <= 0)) {
            return Math.abs(first - second);
        } else {
            return Math.abs(second) + Math.abs(first);
        }
    }

    private int getIndexFromNums(int left, int right, int[] nums, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[right] < target) {
            return right + 1;
        }
        return right;
    }


    public int threeSumClosest_Optimize(int[] nums, int target) {
        Arrays.sort(nums);
        //这个初始值，是个奇怪的选择，应该使用包装类型Integer，第一次循环时，判定是否为null
        Integer res=null;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int second = i + 1, third = nums.length - 1;
            while (second < third) {
                int sum=nums[i]+nums[second]+nums[third];
                if(sum==target){
                    return target;
                }
                if(res==null){
                    res=sum;
                } else if(Math.abs(target-sum)<Math.abs(target-res)){
                    res=sum;
                }
                if(sum<target){
                    int second2=second+1;
                    while(second2<nums.length&&nums[second2]==nums[second2-1]){
                        second2++;
                    }
                    second=second2;
                } else{
                    int third2=third-1;
                    while(third2>i+1 && nums[third2]==nums[third2+1]){
                        third2--;
                    }
                    third=third2;
                }
            }
        }
        return res;
    }
}
