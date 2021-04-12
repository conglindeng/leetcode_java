package easy;

import java.util.Arrays;
import java.util.HashMap;

public class IsToeplitzMatrix_766 {
    public static boolean isToeplitzMatrix(int[][] matrix){
        int height=matrix.length;
        int width=matrix[0].length;

        for(int i=height-1;i>=0;i--){
            int cur=matrix[i][0];
            int first=i+1;
            int second=1;
            while(first<height && second<width){
                if(matrix[first][second]!=cur){
                    return false;
                }
                first++;
                second++;
            }
        }

        for(int j=0;j<width;j++){
            int cur=matrix[0][j];
            int first=1;
            int second=j+1;
            while(first<height && second<width){
                if(matrix[first][second]!=cur){
                    return false;
                }
                first++;
                second++;
            }
        }


        return true;
    }


    public static boolean isToeplitzMatrix1(int[][] matrix) {
        int height=matrix.length;
        int width=matrix[0].length;
        int[] workArray= Arrays.copyOf(matrix[height-1],width);
        for (int i=height-2;i>=0;i--){
            int j=0;
            while(j<width-1){
                if(matrix[i][j]!=workArray[j+1]){
                    return false;
                }
                workArray[j]=workArray[j+1];
                j++;
            }
            workArray[width-1]=matrix[i][j];
        }
        return true;
    }


    public static boolean isToeplitzMatrix2(int[][] matrix) {
        HashMap<Integer,Integer> workMap=new HashMap<>();
        int height=matrix.length;
        int width=matrix[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int key=i-j;
                Integer integer = workMap.get(key);
                if(integer==null){
                    workMap.put(key,matrix[i][j]);
                }else{
                    if(!integer.equals(matrix[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix2(new int[][]{{1,2,3,4},{5,2,1,3},{9,5,1,2}}));
    }
}
