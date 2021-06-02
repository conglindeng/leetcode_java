package leetcode.middle;

import java.util.PriorityQueue;

public class KthLargestValue_1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int height=matrix.length;
        int width=matrix[0].length;
        int[][] p=new int[height][width];
        PriorityQueue<Integer> work=new PriorityQueue<>((x,y)->{return x-y;});
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                p[i][j]=matrix[i][j];
                if(i>0){
                    p[i][j]^=p[i-1][j];
                }
                if(j>0){
                    p[i][j]^=p[i][j-1];
                }
                if(i>0&&j>0){
                    p[i][j]^=p[i-1][j-1];

                }
                work.add(p[i][j]);
                if(work.size()>k){
                    work.poll();
                }
            }
        }
        return  work.peek();
    }
}
