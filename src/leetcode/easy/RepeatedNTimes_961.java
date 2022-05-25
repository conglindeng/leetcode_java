package leetcode.easy;

import java.util.Random;

/**
 * @ClassName RepeatedNTimes_961
 * @Description TODO
 * @Author conglindeng
 * @Date 2022/5/21 22:08
 * @Version 1.0
 */
public class RepeatedNTimes_961 {

    public int repeatedNTimes(int[] nums) {
        Random random = new Random();
        int x = 0, y = 0;
        while (true) {
            x = random.nextInt(nums.length);
            y = random.nextInt(nums.length);
            if (x != y && nums[x] == nums[y]) {
                return nums[x];
            }
        }
    }

}
