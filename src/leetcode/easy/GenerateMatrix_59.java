package leetcode.easy;

public class GenerateMatrix_59 {
    public static int[][] generateMatrix(int n){
        int left=0,right=n-1;
        int top=0,buttom=n-1;
        int[][] result=new int[n][n];

        int index=1;
        while(left<=right&&top<=buttom){
            for(int i=left;i<=right;i++){
                result[top][i]=index++;
            }
            for(int j=top+1;j<=buttom;j++){
                result[j][right]=index++;
            }
            if(left<right&&top<buttom){
                for(int k=right-1;k>=left;k--){
                    result[buttom][k]=index++;
                }
                for(int m=buttom-1;m>top;m--){
                    result[m][left]=index++;
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
        System.out.println(generateMatrix(3));
    }
}
