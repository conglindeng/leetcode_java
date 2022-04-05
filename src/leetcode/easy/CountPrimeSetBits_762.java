package leetcode.easy;

import java.util.Arrays;

public class CountPrimeSetBits_762 {
    int[] num = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 27, 29, 31};

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (Arrays.binarySearch(num, Integer.bitCount(i)) < 0) {
                res++;
            }
        }
        return res;
    }

}
