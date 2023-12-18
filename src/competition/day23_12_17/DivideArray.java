package competition.day23_12_17;

import java.util.Arrays;

/**
 * 100161. 划分数组并满足最大差限制 给你一个长度为 n 的整数数组 nums，以及一个正整数 k 。
 * <p>
 * 将这个数组划分为一个或多个长度为 3 的子数组，并满足以下条件：
 * <p>
 * nums 中的 每个 元素都必须 恰好 存在于某个子数组中。 子数组中 任意 两个元素的差必须小于或等于 k 。 返回一个 二维数组 ，包含所有的子数组。如果不可能满足条件，就返回一个空数组。如果有多个答案，返回 任意一个 即可。
 */
public class DivideArray {

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int m = nums.length / 3;
        int[][] res = new int[m][3];
        int i = 0;
        while (i < m) {
            if (nums[3 * (i + 1) - 1] - nums[3 * i] > k) {
                return new int[][]{};
            }
            for (int j = 0; j < 3; j++) {
                res[i][j] = nums[i * 3 + j];
            }
            i++;
        }
        return res;
    }
}
