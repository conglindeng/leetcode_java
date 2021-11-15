package leetcode.middle;

import java.util.Arrays;

public class BulbSwitch_319 {
    /**
     * 初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭一个。
     *
     * 第三轮，你每三个灯泡就切换一个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换一个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
     *
     * 找出并返回 n 轮后有多少个亮着的灯泡。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/bulb-switcher
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     * n方的时间复杂度，算法是正确的，但超出时间上限
     *
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] info = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j % i == 0) {
                    info[j] ^= 1 ;
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if ((info[i] & 1) == 1) {
                res++;
            }

        }
        return res;
    }


    public int bulbSwitch_Optimize(int n) {
        return (int)Math.sqrt(n+0.5);
    }
}
