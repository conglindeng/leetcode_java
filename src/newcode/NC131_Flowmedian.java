package newcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NC131_Flowmedian {

    private PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b-a);
    private PriorityQueue<Integer> right = new PriorityQueue<>(Comparator.comparingInt(a -> a));

    /**
     * the medians
     *
     * @param operations int整型二维数组 ops
     * @return double浮点型一维数组
     */
    public double[] flowmedian(int[][] operations) {
        // write code here
        List<Double> temp = new ArrayList<>();
        for (int[] operation : operations) {
            if (operation[0] == 1) {
                put(operation[1]);
            } else {
                temp.add(getMedian());
            }
        }
        double[] res = new double[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    private void put(int val) {
        int leftSize = left.size();
        int rightSize = right.size();
        if (leftSize == rightSize) {
            if (right.isEmpty() || val < right.peek()) {
                left.add(val);
            } else {
                left.add(right.poll());
                right.add(val);
            }
        } else {
            if (val > left.peek()) {
                right.add(val);
            } else {
                right.add(left.poll());
                left.add(val);
            }
        }
    }

    private double getMedian() {
        int leftSize = left.size();
        int rightSize = right.size();
        if (leftSize == 0) {
            return -1;
        }
        if (leftSize == rightSize) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}
