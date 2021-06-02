package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {
    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> result= new ArrayList<>();
        int height=matrix.length;
        int width=matrix[0].length;

        int left=0;
        int right=width-1;
        int top=0;
        int buttom=height-1;

        while(left<=right && top<=buttom){

            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }

            for(int j=top;j<=buttom;j++){
                result.add(matrix[right][j]);
            }

            if(left<right && top<buttom){
                for(int k=right;k>=left;k--){
                    result.add(matrix[k][buttom]);
                }

                for(int m=buttom;m>top;m--){
                    result.add(matrix[left][m]);
                }
            }
            left++;
            right--;
            top++;
            buttom--;

        }
        return result;
    }


    public static void main(String[] args) {

    }
}
