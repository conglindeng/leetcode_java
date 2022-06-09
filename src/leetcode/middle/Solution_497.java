package leetcode.middle;

import java.util.Arrays;
import java.util.Random;

public class Solution_497 {

    int[][] rects;
    int[] count;
    Random random;
    int length;

    //计算出所有的点 count
    public Solution_497(int[][] rects) {
        this.rects = rects;
        length = rects.length;
        count = new int[length + 1];
        Arrays.sort(this.rects, (a, b) -> {
            int am = (Math.abs(a[0] - a[2]) + 1) * (Math.abs(a[1] - a[3]) + 1);
            int bm = (Math.abs(b[0] - b[2]) + 1) * (Math.abs(b[1] - b[3]) + 1);
            return am - bm;
        });
        for (int i = 0; i < length; i++) {
            int[] rect = this.rects[i];
            int x1 = rect[0];
            int y1 = rect[1];
            int x2 = rect[2];
            int y2 = rect[3];
            count[i + 1] = count[i] + (Math.abs(x1 - x2) + 1) * (Math.abs(y1 - y2) + 1);
        }
        random = new Random();
    }

    public int[] pick() {
        //先确定是哪个长方形区域，再计算是该长方形区域中哪一个点
        int i = random.nextInt(count[length]);
        int idx = getIdx(i);
        return getPoints(rects[idx], i - count[idx]);
    }

    private int[] getPoints(int[] rect, int i) {
        int h = Math.abs(rect[0] - rect[2]) + 1;
        return new int[]{rect[0] + i % h, rect[1] + i / h};
    }

    private int getIdx(int i) {
        int left = 0, right = length, mid;
        //最后一个小于等于
        while (left < right) {
            mid = left + ((right - left + 1) >> 1);
            if (count[mid] > i) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}