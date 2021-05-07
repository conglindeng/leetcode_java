package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindMaxKNums {
    /**
     * 获取无序数组中查找最大的K个数
     * @param nums
     * @return
     */
    public List<Integer> findMaxKNums(int[] nums,int k){
        PriorityQueue<Integer> workQueue=new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int num : nums) {
            workQueue.offer(num);
            if (workQueue.size() > k) {
                workQueue.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!workQueue.isEmpty()){
            result.add(workQueue.poll());
        }
        return result;
    }
}
