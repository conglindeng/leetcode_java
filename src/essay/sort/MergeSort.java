package essay.sort;

public class MergeSort {


    public int[] mergeSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        return doMergeSort(nums, 0, nums.length - 1);
    }


    private int[] doMergeSort(int[] nums, int left, int right) {
        if (right == left) {
            return new int[]{nums[left]};
        }
        //split by mid
        int mid = ((right - left) >> 1) + left;
        int[] leftNums = doMergeSort(nums, left, mid);
        int[] rightNums = doMergeSort(nums, mid + 1, right);
        //do merge
        int[] newNums = new int[right - left + 1];
        int i = 0;
        int j = 0;
        int newIdx = 0;
        while (i < leftNums.length && j < rightNums.length) {
            if (leftNums[i] < rightNums[j]) {
                newNums[newIdx++] = leftNums[i++];
            } else {
                newNums[newIdx++] = rightNums[j++];
            }
        }
        while (i < leftNums.length) {
            newNums[newIdx++] = leftNums[i++];

        }
        while (j < rightNums.length) {
            newNums[newIdx++] = rightNums[j++];
        }
        return newNums;
    }
}


