package leetcode.middle;

public class SingleNonDuplicate_540 {
    public int singleNonDuplicate(int[] nums) {
        //二分查找，比较时判断前后的数量，哪个为奇数，说明单个出现的数在哪边
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1;
        int mid;
        while (l < r) {
            mid = (r - l) / 2 + l;
            if (r - l == 2) {
                if (nums[l] == nums[l + 1]) {
                    return nums[r];
                }
                return nums[l];
            }
            boolean rFlag = false;
            int rCount = r - mid;
            if (nums[mid] == nums[mid + 1]) {
                rCount++;
                rFlag = true;
            }
            if (rCount % 2 != 0) {
                l = rFlag ? mid : mid + 1;
            } else {
                r = rFlag ? mid - 1 : mid;
            }
        }
        return nums[r];
    }

    public int singleNonDuplicate_Optimize(int[] nums) {
        int l = 0, r = nums.length - 1;
        int mid;
        while (l < r) {
            mid = (r - l) / 2 + l;
            if (nums[mid] == nums[mid ^ 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
