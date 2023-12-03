package leetcode.middle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import javafx.util.Pair;

public class CarPooling_1094 {


    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (i, j) -> {
            if (i[1] == j[1]) {
                return i[2] - j[2];
            }
            return i[1] - j[1];
        });
        int maxTime = -1;
        for (int[] trip : trips) {
            maxTime = Math.max(maxTime, trip[2]);
        }
        PriorityQueue<Pair<Integer, Integer>> outOfCar = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));

        int curPas = 0;
        int j = 0;
        for (int i = 0; i <= maxTime; i++) {
            if (j == trips.length) {
                return true;
            }
            while (outOfCar.size() > 0) {
                if (outOfCar.peek().getValue() > i) {
                    break;
                }
                curPas -= outOfCar.poll().getKey();
            }
            while (j < trips.length && trips[j][1] == i) {
                curPas += trips[j][0];
                Pair<Integer, Integer> e = new Pair(trips[j][0], trips[j][2]);
                outOfCar.add(e);
                j++;
            }
            if (curPas > capacity) {
                return false;
            }

        }

        return true;
    }
}
