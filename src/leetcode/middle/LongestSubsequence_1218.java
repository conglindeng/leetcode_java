package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class LongestSubsequence_1218 {

    /**
     * 给你一个整数数组arr和一个整数difference，请你找出并返回 arr中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
     * <p>
     * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [1,2,3,4], difference = 1
     * 输出：4
     * 解释：最长的等差子序列是 [1,2,3,4]。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence(int[] arr, int difference) {
        // 当前元素为i，判断当前元素i-difference和i+difference是否在之前出现过，若出现过，则将之加入到i-difference或者i+difference中
        //需要一个hashmap，key为当前元素，value为当前符合等差数列的元素
        if (arr.length <= 0) {
            return 0;
        }
        Map<Integer, Integer> info = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            int less = info.getOrDefault(cur - difference, 0);
            int curSize = less + 1;
            info.put(cur, curSize);
        }
        return info.values().stream().max(Integer::compareTo).get();
    }
}
