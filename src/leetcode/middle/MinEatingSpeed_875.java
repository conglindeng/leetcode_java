package leetcode.middle;

public class MinEatingSpeed_875 {

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Integer.max(pile, max);

        }
        int left = 1, right = max;
        int mid = -1;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            int curDays = getCurDays(piles, mid);
            if (curDays > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int getCurDays(int[] piles, int curSpeed) {
        int res = 0;
        for (int pile : piles) {
            res += (pile + curSpeed - 1) / curSpeed;
        }
        return res;
    }


}
