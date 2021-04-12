package easy;

import java.util.concurrent.Callable;

public class Transpose_867 {
    public static int[][] transpose(int[][] matrix){
        int height=matrix.length;
        int width=matrix[0].length;
        int[][] result=new int[width][height];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                result[j][i]=matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(transpose(new int[][]{{1,2,3},{4,5,6}}));
        new Thread(()->{
            System.out.println();
        }).start();
    }
}
