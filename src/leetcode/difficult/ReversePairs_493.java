package leetcode.difficult;

/**
 * @ClassName: ReversePairs_493
 * @author: conglindeng
 */
public class ReversePairs_493 {

    int res = 0;

    public int reversePairs(int[] nums) {
        return -1;
    }


    private void mergeSort(int[] nums, int begin, int end) {
        int mid = begin + (end - begin) / 2;
        mergeSort(nums, begin, mid - 1);
        mergeSort(nums, mid, end);
        merge(nums, begin, mid - 1, mid, end);
    }

    private void merge(int[] nums, int left, int right, int begin, int end) {
        int[] temp = new int[end - left + 1];
        int cur2 = begin;
        int cur1 = left;
        while (cur1 <= right && cur2 <= end) {

        }
    }


}
