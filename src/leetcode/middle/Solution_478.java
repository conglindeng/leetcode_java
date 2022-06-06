package leetcode.middle;

import java.util.Random;

class Solution_478 {

    double radius;
    double x_center;
    double y_center;
    Random random;

    public Solution_478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        random = new Random();
    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * 2 * radius - radius;
            double y = random.nextDouble() * 2 * radius - radius;
            if (x * x + y * y >= radius * radius) {
                return new double[]{x_center + x, y_center + y};
            }
        }
    }


}