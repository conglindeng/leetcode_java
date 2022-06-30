package leetcode.difficult;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Solution_710 {

    int size;
    Map<Integer, Integer> ints;
    Random random;

    public Solution_710(int bound, int[] blacklist) {
        this.size = bound - blacklist.length;
        ints = new HashMap<>();
        random = new Random();

        Set<Integer> blackNums = new HashSet<>();
        for (int i : blacklist) {
            if (i >= this.size) {
                blackNums.add(i);
            }
        }
        int m = this.size;
        for (int i : blacklist) {
            if (i < this.size) {
                while (blackNums.contains(m)) {
                    m++;
                }
                ints.put(i, m);
                m++;
            }
        }
    }

    public int pick() {
        int i = random.nextInt(size);
        return ints.getOrDefault(i, i);
    }


}