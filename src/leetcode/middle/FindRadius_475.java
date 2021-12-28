package leetcode.middle;

import java.util.Arrays;

public class FindRadius_475 {
    public int findRadius(int[] houses, int[] heaters) {
        int res = 1;
        Arrays.sort(heaters);
        for (int house : houses) {
            int left = getLastLessThanOrEquals(house, heaters);
            int right = left + 1;
            int leftDistance = left < 0 ? Integer.MAX_VALUE : house - heaters[left];
            int rightDistance = right >= heaters.length ? Integer.MAX_VALUE : heaters[right] - house;
            res = Math.max(res, Math.min(leftDistance, rightDistance));
        }
        return res;
    }


    private int getLastLessThanOrEquals(int target, int[] heaters) {
        int left = 0, right = heaters.length - 1;
        if (heaters[left] > target) {
            return -1;
        }
        int mid;
        while (left < right) {
            mid = left + (right - left + 1) / 2;
            if (heaters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
