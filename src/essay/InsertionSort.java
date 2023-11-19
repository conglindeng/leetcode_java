package essay;

public class InsertionSort {

    //
    public void insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            int cur = nums[i];
            while (j > 0 && nums[j - 1] > cur) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = cur;
        }
    }
}
