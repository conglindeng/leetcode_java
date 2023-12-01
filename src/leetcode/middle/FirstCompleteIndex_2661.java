package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class FirstCompleteIndex_2661 {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] index = new int[m + n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = mat[i][j] - 1;
                index[cur] = new int[]{i, j};
            }
        }
        Map<Integer, Integer> colored = new HashMap<>();
        for (int i = 0; i < m * n; i++) {
            int[] position = index[arr[i] - 1];
            colored.put(position[0], colored.getOrDefault(position[0], 0) + 1);
            colored.put(m + position[1], colored.getOrDefault(m + position[1], 0) + 1);
            if (colored.getOrDefault(position[0], 0) == n) {
                return i;
            }
            if (colored.getOrDefault(m + position[1], 0) == m) {
                return i;
            }
        }
        return -1;
    }

}
