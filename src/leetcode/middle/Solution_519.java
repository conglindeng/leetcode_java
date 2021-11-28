package leetcode.middle;

import java.util.*;

class Solution_519 {
    Map<Integer, Integer> info;
    int m, n, total;
    Random random;

    public Solution_519(int m, int n) {
        total = m * n;
        this.m = m;
        this.n = n;
        info = new HashMap<>();
        random = new Random();

    }

    public int[] flip() {
        int i = random.nextInt(total);
        total--;
        int index = info.getOrDefault(i, i);
        info.put(i, info.getOrDefault(total, total));
        return new int[]{index / n, index % n};
    }

    public void reset() {
        info.clear();
        total = m * n;
    }
}