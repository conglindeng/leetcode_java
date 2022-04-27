package algorithm;

import java.util.Random;

/**
 * 蓄水池采样
 */
public class ReservoirSampling {
    Random random = new Random();

    /**
     * 在num中抽取等于target值的index，保证nums中target数量大于等于k个
     * 要求target的每一个下标放入结果中的几率是相等的
     */
    public int[] getSample(int[] nums, int target, int k) {
        int[] res = new int[k];
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            //等于的时候才进行处理
            if (nums[i] == target) {
                cnt++;
                //当前的target还没有装满，直接放入即可
                if (cnt <= k) {
                    res[cnt-1] = i;
                } else {
                    int m = random.nextInt(cnt);
                    if (m < k) {
                        res[m] = i;
                    }
                }
            }
        }
        return res;
    }
}
