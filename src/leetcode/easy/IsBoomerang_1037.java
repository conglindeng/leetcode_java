package leetcode.easy;

import java.util.Arrays;

public class IsBoomerang_1037 {

    public boolean isBoomerang(int[][] points) {
        int[] p1 = points[0];
        int[] p2 = points[1];
        int[] p3 = points[2];
        if (Arrays.equals(p1, p2) || Arrays.equals(p2, p3) || Arrays.equals(p1, p3)) {
            return false;
        }
        return (p2[1] - p1[1]) * (p3[0] - p1[0]) != (p3[1] - p1[1]) * (p2[0] - p1[0]);
    }
}
