package leetcode.middle;

public class FindPeakElement_162 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            boolean l = compare(mid, mid - 1, nums);
            boolean r = compare(mid, mid + 1, nums);
            if (l && r) {
                return mid;
            }
            if (l) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * idx1对应的元素是否大于idx2的元素
     * 是返回true
     *
     * @param idx1
     * @param idx2
     * @param nums
     * @return
     */
    private boolean compare(int idx1, int idx2, int[] nums) {
        if (idx2 == nums.length || idx2 == -1) {
            return true;
        }
        return nums[idx1] > nums[idx2];
    }
}
