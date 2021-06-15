package leetcode.easy;

import java.util.PriorityQueue;

public class LastStoneWeight_1046 {
    public int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> work=new PriorityQueue<>((a,b)->b-a);
        for (int stone:stones){
            work.add(stone);
        }
        while(work.size()>1){
            Integer first = work.poll();
            Integer second = work.poll();
            work.add(first-second);
        }
        return work.poll();
    }

    //31,26,33,21,40
    public int lastStoneWeight_new(int[] stones){
        PriorityQueue<Integer> work=new PriorityQueue<>((a,b)->b-a);
        for (int stone:stones){
            work.add(stone);
        }
        while(work.size()>1){
            Integer first = work.poll();
            Integer second = work.poll();
            if(first==second){
                continue;
            }
            work.add(first-second);
        }
        if(work.size()==1){
            return work.poll();
        }
        return 0;
    }

}
