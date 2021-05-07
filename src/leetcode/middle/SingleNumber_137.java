package leetcode.middle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SingleNumber_137 {
    public static int singleNumber(int[] nums){
        Map<Integer,Integer> count=new HashMap<>();
        for (int num : nums) {
            count.put(num,count.getOrDefault(num,0)+1);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = count.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue().equals(1)){
                return next.getKey();
            }
        }
        return -1;
    }
}
