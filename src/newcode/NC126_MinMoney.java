package newcode;

import java.util.Arrays;

public class NC126_MinMoney {
    /**
     * 最少货币数
     *
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public int minMoney(int[] arr, int aim) {
        // write code here
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        if (aim == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                if(arr[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.min(dp[i][j-arr[i-1]]+1,dp[i-1][j]);
                }
            }
        }
        return 0;
    }

    /**
     * 有序数组中小于等于target的第一个数
     *
     * @param arr    数组
     * @param target 目标值
     * @return 第一个数的index，-1为没找到（）
     */
    private int findFistLessThanOrEquals(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0, right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left + 1) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (arr[left] > target) {
            return -1;
        }
        return left;
    }
}
