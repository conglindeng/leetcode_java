package leetcode.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NumberOfBoomerangs_447 {

    /**
     * 欧式距离，相减，平方，再相加，开根号
     *
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int[] p1 : points) {
                int distance = (p1[0] - p[0]) * (p1[0] - p[0]) + (p1[1] - p[1]) * (p1[1] - p[1]);
                cnt.put(distance, cnt.getOrDefault(distance, 0) + 1);
            }
            for (Entry<Integer, Integer> entry : cnt.entrySet()) {
                res += entry.getValue() * (entry.getValue() - 1);
            }
        }
        return res;
    }
}
