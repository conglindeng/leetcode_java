package leetcode.easy;

public class SortArrayByParity_905 {

    public int[] sortArrayByParity(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            //如果fast
            if (nums[fast] % 2 == 0) {
                //说明当前的数字是偶数，需要在 [slow) 中寻找一个放置的位置
                while (slow < fast) {
                    if (nums[slow] % 2 != 0) {
                        int temp = nums[slow];
                        nums[slow] = nums[fast];
                        nums[fast] = temp;
                        slow++;
                        break;
                    }
                    slow++;
                }
            }
            fast++;
        }
        return nums;
    }
}
