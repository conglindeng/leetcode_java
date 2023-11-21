package leetcode.middle;

public class MinDeletion_2216 {

    public int minDeletion(int[] nums) {
        int ans = 0;
        boolean checked = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] && checked) {
                ans++;
            } else {
                checked = !checked;
            }
        }
        if ((nums.length - ans) % 2 != 0) {
            ans++;
        }
        return ans;
    }
}
