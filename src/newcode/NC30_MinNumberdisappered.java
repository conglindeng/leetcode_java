package newcode;

import java.io.Serializable;

public class NC30_MinNumberdisappered {
    /**
     * 给定一个无序数组arr，找到数组中未出现的最小正整数
     * 例如arr = [-1, 2, 3, 4]。返回1
     * arr = [1, 2, 3, 4]。返回5
     * <p>
     * [要求]
     * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
     * <p>
     * return the min number
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int minNumberdisappered(int[] arr) {
        // write code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = 0;
        int n = arr.length + 1;
            int min = Integer.MAX_VALUE;
        for (int i : arr) {
            sum += i;
            min = Math.min(i, min);
        }
        if (min < 0 && min + n > 0) {
            n += 1;
        }
        return n * (min + min + n - 1) / 2 - sum;
    }
}
