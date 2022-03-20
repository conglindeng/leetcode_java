package leetcode.middle;

import java.util.*;

public class NetworkBecomesIdle_2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        //此题意 应该是找 到0节点花费时间最大的节点
        //如何定义花费时间：间隔+到0节点经过的节点数
        //一轮一轮的往外扩散，逐步更新最大值。直到所有的节点都扫描完
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        for (int[] edge : edges) {
            edgeMap.putIfAbsent(edge[0], new ArrayList<>());
            edgeMap.putIfAbsent(edge[1], new ArrayList<>());
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }
        int idx = 1;
        int max = Integer.MIN_VALUE;
        int n = patience.length;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        List<Integer> next = new ArrayList<>();
        next.add(0);
        while (visited.size() != n) {
            List<Integer> temp = new ArrayList<>();
            for (Integer integer : next) {
                for (Integer i : edgeMap.get(integer)) {
                    if (!visited.contains(i)) {
                        if (patience[i] > (idx * 2)) {
                            max = Math.max(idx * 2 + 1, max);
                        } else {
                            int count = (idx * 2 - 1) / patience[i];
                            //最后一条消息是在0+count*patience[i]时刻发出的
                            max = Math.max(count * patience[i] + idx * 2 + 1, max);
                        }
//                        int time = patience[i] * ((2 * idx - 1) / patience[i]) + 2 * idx + 1;
//                        max = Math.max(time, max);
                        temp.add(i);
                        visited.add(i);
                    }
                }
            }
            idx++;
            next = temp;
        }
        return max;
    }
}
