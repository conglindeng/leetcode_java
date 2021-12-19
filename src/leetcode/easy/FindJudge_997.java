package leetcode.easy;

import java.util.*;

public class FindJudge_997 {
    public int findJudge(int n, int[][] trust) {
        if (trust == null || trust.length == 0) {
            return -1;
        }
        Map<Integer, TreeSet<Integer>> trustCount = new HashMap<>();
        Map<Integer, TreeSet<Integer>> trustedCount = new HashMap<>();
        List<Integer> candidate = new ArrayList<>();
        for (int[] ints : trust) {
            int person = ints[0];
            int trustor = ints[1];
            trustCount.putIfAbsent(trustor, new TreeSet<>());
            trustedCount.putIfAbsent(person, new TreeSet<>());
            trustedCount.get(person).add(trustor);
            TreeSet<Integer> persons = trustCount.get(trustor);
            persons.add(person);
            if (persons.size() == n - 1) {
                candidate.add(trustor);
            }
        }
        for (Integer integer : candidate) {
            if (!trustedCount.containsKey(integer) || trustedCount.get(integer).size() == 0) {
                return integer;
            }
        }
        return -1;
    }

    public int findJudge_Optimize(int n, int[][] trust) {
        //信任的人数
        int[] trustCount = new int[n + 1];
        //被信任的人数
        int[] trustedCount = new int[n + 1];

        for (int[] ints : trust) {
            trustCount[ints[0]]++;
            trustedCount[ints[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == 0 && trustedCount[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

}
