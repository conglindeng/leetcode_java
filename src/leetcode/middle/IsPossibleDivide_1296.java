package leetcode.middle;

import java.util.*;

public class IsPossibleDivide_1296 {
    /**
     * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
     * 如果可以，请返回 True；否则，返回 False。
     * <p>
     * <p>
     * 注意：此题目与 846 重复：https://leetcode-cn.com/problems/hand-of-straights/
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,3,4,4,5,6], k = 4
     * 输出：true
     * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int length = nums.length;
        if (length % k != 0) {
            return false;
        }
        boolean[] flag = new boolean[length];
        int scaned = 0;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            //找到一个起始点m，判断m到m+k是否都存在于数组中，并把使用过的数组
            if (!flag[i]) {
                int cur = nums[i];
                scaned++;
                for (int j = 1; j < k; j++) {
                    int index = findIndex(cur + j, nums, flag);
                    if (index == -1) {
                        return false;
                    } else {
                        flag[index] = true;
                        scaned++;
                        if (scaned == nums.length) {
                            return true;
                        }
                    }
                }
            }
        }
        return true;
    }

    public int findIndex(int target, int[] nums, boolean[] flag) {
        int left = 0, right = nums.length;
        int mid = -1;
        //先找到第一个大于等于target的index
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left > nums.length - 1) {
            return -1;
        }
        for (int i = left; i < nums.length; i++) {
            if (nums[i] == target && !flag[i]) {
                return i;
            }
        }
        return -1;
    }


    public boolean isPossibleDivide_Optimize(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int length = nums.length;
        if (length % k != 0) {
            return false;
        }
        Map<Integer, Integer> count = new TreeMap<>();
        for (int i = 0; i < length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = count.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            if (value > 0) {
                for (int i = 0; i < k; i++) {
                    Integer c = count.get(key + i);
                    if (c != null && c >= value) {
                        count.put(key + i, c - value);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
