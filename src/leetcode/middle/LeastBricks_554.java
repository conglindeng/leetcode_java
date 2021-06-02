package leetcode.middle;

import java.util.*;

public class LeastBricks_554 {
    public static int leastBricks(List<List<Integer>> wall){
        Map<Integer,Integer> heightMap=new HashMap<>();
        for (List<Integer> integers : wall) {
            int sum=0;
            for (int i = 0; i < integers.size()-1; i++) {
                sum+=integers.get(i);
                heightMap.put(sum,heightMap.getOrDefault(sum,1)+sum);
            }
        }
        int max=-1;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : heightMap.entrySet()) {
            max=Math.max(max,integerIntegerEntry.getValue());
        }

        return wall.size()-max;
    }
}
