package leetcode.middle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HighestPeak_1765 {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] highestPeak(int[][] isWater) {
        int height = isWater.length;
        int width = isWater[0].length;
        int[][] res = new int[height][width];
        int[][] processed = new int[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(processed[i], -1);
        }
        Queue<int[]> work = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isWater[i][j] == 1) {
                    res[i][j] = 0;
                    processed[i][j] = 0;
                    work.add(new int[]{i, j});
                }
            }
        }
        while (!work.isEmpty()) {
            int[] poll = work.poll();
            int i = poll[0], j = poll[1];
            for (int[] dir : dirs) {
                int m = i + dir[0], n = j + dir[1];
                if (m >= 0 && m < height && n >= 0 && n < width && processed[m][n] == -1) {
                    processed[m][n] = 0;
                    res[m][n] = res[i][j] + 1;
                    work.add(new int[]{m, n});
                }
            }
        }
        return res;
    }
}
