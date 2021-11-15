package leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreArray_1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> linkInfo = new HashMap<>();
        int height = adjacentPairs.length;
        for (int i = 0; i < height; i++) {
            int[] adjacentPair = adjacentPairs[i];
            linkInfo.putIfAbsent(adjacentPair[0], new ArrayList<>());
            linkInfo.putIfAbsent(adjacentPair[1], new ArrayList<>());
            linkInfo.get(adjacentPair[0]).add(adjacentPair[1]);
            linkInfo.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        int[] res = new int[height+1];
        for (Map.Entry<Integer, List<Integer>> entry : linkInfo.entrySet()) {
            if (entry.getValue().size() == 1) {
                res[0] = entry.getKey();
            }
        }
        for (int i = 1; i <= height; i++) {
            List<Integer> pre = linkInfo.get(res[i - 1]);
            if (pre.size() == 1) {
                res[i] = pre.get(0);
            } else {
                if (pre.get(0) == res[i - 2]) {
                    res[i] = pre.get(1);
                } else {
                    res[i] = pre.get(0);
                }
            }
        }
        return res;
    }
}
