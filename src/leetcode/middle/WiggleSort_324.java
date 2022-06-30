package leetcode.middle;

import java.util.Arrays;

public class WiggleSort_324 {

    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int n = clone.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, k--, j--) {
            nums[i] = clone[j];
            if (i + 1 < n) {
                nums[i+1] = clone[k];
            }
        }
    }
}
