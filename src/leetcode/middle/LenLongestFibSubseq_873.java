package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class LenLongestFibSubseq_873 {

    public int lenLongestFibSubseq(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                res = Math.max(res, getFibSubSeqLength(i, j, arr));
            }
        }
        return res;
    }

    private int getFibSubSeqLength(int i, int j, int[] arr) {
        int first = arr[i];
        int second = arr[j];
        int count = 0;
        int index = search(arr, j + 1, first + second);
        while (index != -1) {
            count++;
            first = second;
            second = arr[index];
            index = search(arr, index + 1, first + second);
        }
        return count == 0 ? 0 : count + 2;
    }

    private int search(int[] arr, int left, int target) {
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    private Map<Integer, Integer> num2Inx = new HashMap<>();


    public int lenLongestFibSubseq_OptimizeWithDP(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            num2Inx.put(arr[i], i);
        }
        int res = 0;
        int[][] dp = new int[length][length];
        for (int i = 2; i < length; i++) {
            int j = i - 1;
            for (; j > 0 && arr[i] < 2 * arr[j]; j--) {
                int k = num2Inx.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                res = Math.max(res, dp[j][i]);
            }
        }
        return res;
    }

}