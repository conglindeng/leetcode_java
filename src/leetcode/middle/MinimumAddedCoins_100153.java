package leetcode.middle;

import java.util.Arrays;

public class MinimumAddedCoins_100153 {

    public int minimumAddedCoins(int[] coins, int target) {
        int res = 0;
        int s = 1; // cur range [0,s-1]  s-1>=target s>target
        Arrays.sort(coins);
        int i = 0;
        while (s <= target) {
            if (i < coins.length && coins[i] <= s) {
                s += coins[i];
                i++;
            } else {
                s *= 2;
                res++;
            }
        }
        return res;
    }

}
