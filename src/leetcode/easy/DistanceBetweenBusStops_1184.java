package leetcode.easy;

public class DistanceBetweenBusStops_1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int left = start, right = destination;
        if (right < left) {
            int temp = left;
            left = right;
            right = temp;
        }
        int count = 0;
        int one = 0;
        for (int i = 0; i < distance.length; i++) {
            count += distance[i];
            if (i >= left && i < right) {
                one += distance[i];
            }
        }
        return Math.min(one, count - one);
    }
}
