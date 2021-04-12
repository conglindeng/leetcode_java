package middle;

import java.util.Arrays;

public class NumMatrix_304 {

    int[][] matrix;

    public NumMatrix_304(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return;
        }
        int height=matrix.length;
        int width=matrix[0].length;
        this.matrix=new int[height][width];
        for(int i=0;i<height;i++){
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, width);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int height=matrix.length;
        int width=matrix[0].length;
        int result=0;
        for(int i=row1;i<height&&i<=row2;i++){
            for(int j=col1;j<width&&j<=col2;j++){
                result+=matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumMatrix_304 d=new NumMatrix_304(new int[][]{
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        });
        System.out.println(
                d.sumRegion(2,1,4,3)
        );
    }
}
