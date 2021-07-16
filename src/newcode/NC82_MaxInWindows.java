package newcode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NC82_MaxInWindows {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        PriorityQueue<Integer> work=new PriorityQueue<>((a,b)->b-a);
        ArrayList<Integer> res =new ArrayList<>();
        if(size<1){
            return res;
        }
        if(size>num.length){
            return res;
        }
        for(int i=0;i<size-1;i++){
            work.add(num[i]);
        }
        int left =0;
        int right=size-1;
        while(right<num.length){
            work.add(num[right++]);
            res.add(work.peek());
            work.remove(num[left++]);
        }
        return res;
    }

}
