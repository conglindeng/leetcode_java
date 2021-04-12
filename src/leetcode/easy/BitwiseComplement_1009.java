package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class BitwiseComplement_1009 {
    public static int bitwiseComplement(int N){
        int divisor=N;;
        Queue<Integer> queue=new LinkedList<>();
        while(divisor/2!=0){
            queue.offer(divisor%2);
            divisor/=2;
        }
        if(divisor==1){
            queue.offer(divisor);
        }
//        queue.
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(10));
    }
}
