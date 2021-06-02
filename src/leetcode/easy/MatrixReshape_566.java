package leetcode.easy;

public class MatrixReshape_566 {
    public static int[][] matrixReshape(int[][] nums,int r,int c){
        int length=nums[0].length*nums.length;
        if(length!=r*c){
            return nums;
        }
        int[][] result=new int[r][c];
        int count=0;
        for (int[] num : nums) {
            for (int i:num){
                int first=count/c;
                int second=count%c;
                result[first][second]=i;
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
