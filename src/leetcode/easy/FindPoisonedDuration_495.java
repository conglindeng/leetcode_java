package leetcode.easy;

public class FindPoisonedDuration_495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int res = 0;
        int rightRange = -1;
        for (int i = 0; i < timeSeries.length; i++) {
            int cur = timeSeries[i];
            if (rightRange <= (cur + duration) && rightRange >= cur) {
                res += cur + duration - rightRange;
            } else {
                res += duration;
            }
            rightRange = cur + duration;
        }
        return res;
    }
}
