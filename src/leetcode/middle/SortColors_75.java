package leetcode.middle;

public class SortColors_75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int redCount = 0;
        int whiteCount = 0;
        for (int num : nums) {
            if (num == 0) {
                redCount++;
            } else if (num == 1) {
                whiteCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < redCount) {
                nums[i] = 0;
            } else if (i < redCount + whiteCount) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public void sortColors_Optimize(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int cur = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                swap(nums, cur, i);
                cur++;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                swap(nums, cur, i);
                cur++;
            }
        }
    }


    public void sortColors_Optimize2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int redCur = 0;
        int whiteCur = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                swap(nums, redCur, i);
                if (redCur < whiteCur) {
                    swap(nums, whiteCur, i);
                }
                redCur++;
                whiteCur++;

            } else if (nums[i] == 1) {
                swap(nums, whiteCur, i);
                whiteCur++;
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
