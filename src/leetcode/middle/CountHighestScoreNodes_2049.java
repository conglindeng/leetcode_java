package leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountHighestScoreNodes_2049 {
    Map<Integer, List<Integer>> childrenMap = new HashMap<>();
    Map<Integer, Integer> countMap = new HashMap<>();

    public int countHighestScoreNodes(int[] parents) {
        // 最大的数目必然是叶子节点，此时数目值为数组长度n-1
        // 所以转化为寻找没有子节点的节点数目
        int n = parents.length;
        long maxScore = 0;
        int res = 0;
        for (int i = 1; i < n; i++) {
            childrenMap.putIfAbsent(parents[i], new ArrayList<>());
            childrenMap.get(parents[i]).add(i);
        }
        for (int i = 0; i < n; i++) {
            long curScore = 1;
            List<Integer> integers = childrenMap.get(i);
            if (integers == null || integers.size() == 0) {
                curScore = n - 1;
            } else {
                int otherCount = n - 1;
                for (Integer integer : integers) {
                    int curCount = getCount(integer);
                    curScore *= curCount;
                    otherCount -= curCount;
                }
                curScore *= (otherCount == 0 ? 1 : otherCount);
            }
            if (curScore > maxScore) {
                res = 1;
                maxScore = curScore;
            } else if (curScore == maxScore) {
                res++;
            }
        }
        return res;
    }

    private int getCount(int id) {
        if (countMap.containsKey(id)) {
            return countMap.get(id);
        }
        int count = 1;
        if (childrenMap.get(id) != null) {
            for (Integer integer : childrenMap.get(id)) {
                count += getCount(integer);
            }
        }
        countMap.put(id, count);
        return count;
    }
}
