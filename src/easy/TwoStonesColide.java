package easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class TwoStonesColide {



    public static int colide(int[] stones){
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(stones.length,(a,b)->b-a);
        for (int i = 0; i < stones.length; i++) {
            queue.add(stones[i]);
        }
        while (queue.size() > 1 ){
            Integer a = queue.poll();
            Integer b = queue.poll();
            queue.offer(a-b);
        }
        if(queue.size()==1){
            return queue.peek();
        }
        return 0;
    }
}
