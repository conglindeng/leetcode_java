package leetcode.easy;

/**
 * @ClassName LargestTriangleArea_812
 * @Author conglindeng
 * @Date 2022/5/15 22:38
 * @Version 1.0
 */

public class LargestTriangleArea_812 {

    public double largestTriangleArea(int[][] points) {
        double res = 0D;
        int l = points.length;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    res = Math.max(res,
                        getM(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0],
                            points[k][1]));
                }
            }
        }
        return res;
    }

    private double getM(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x3 * y1 + x2 * y3 - x3 * y2 - x2 * y1 - x1 * y3);
    }
}
