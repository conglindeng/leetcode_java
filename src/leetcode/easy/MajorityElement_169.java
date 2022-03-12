package leetcode.easy;

import java.util.Arrays;
import java.util.Random;

public class MajorityElement_169 {

    /**
     * 排序，直接区中间元素
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        //1.mapCount  时间空间都为o(n)
        //2.排序 时间：nlogn
        //3.
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 分治，找左右两个子区域的主要元素，再进行合并筛选
     *
     * @param nums
     * @return
     */
    public int majorityElementWithPartition(int[] nums) {
        return doFindWithPartition(nums, 0, nums.length - 1);
    }

    private int doFindWithPartition(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftNum = doFindWithPartition(nums, left, mid);
        int rightNum = doFindWithPartition(nums, mid + 1, right);
        int leftCount = countOfItem(leftNum, nums, left, right);
        int rightCount = countOfItem(rightNum, nums, left, right);
        return leftCount > rightCount ? leftNum : rightNum;
    }

    private int countOfItem(int item, int[] nums, int begin, int end) {
        int res = 0;
        for (int i = begin; i <= end; i++) {
            if (nums[i] == item) {
                ++res;
            }
        }
        return res;
    }

    /**
     * 随机取一个index对应的数，判断该数是否是主要元素
     *
     * @param nums
     * @return
     */
    public int majorityElementWithRandom(int[] nums) {
        Random random = new Random();
        int n = nums.length;
        int i;
        while (true) {
            i = random.nextInt(n);
            int count = countOfItem(nums[i], nums, 0, n - 1);
            if (count > n / 2) {
                break;
            }
        }
        return nums[i];
    }

    public int majorityElementWithBoyer_Moore(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }

}
