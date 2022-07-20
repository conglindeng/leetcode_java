package leetcode.middle;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MyCalendarTwo_WithAdjacentDifference_731 {

    //adjacent_difference-相邻差

    Map<Integer, Integer> treeMap;

    public MyCalendarTwo_WithAdjacentDifference_731() {
        treeMap = new TreeMap<>();
    }


    public boolean book(int start, int end) {
        int maxCount = 0;
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);
        //不能HashMap是因为下面的遍历如果是TreeMap的话，是隐含有大小的前后关系的
        for (Entry<Integer, Integer> entry : treeMap.entrySet()) {
            maxCount += entry.getValue();
            if (maxCount > 2) {
                treeMap.put(start, treeMap.getOrDefault(start, 0) - 1);
                treeMap.put(end, treeMap.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }


}