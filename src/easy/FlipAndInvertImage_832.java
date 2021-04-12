package easy;

public class FlipAndInvertImage_832 {
    public static int[][] flipAndInvertImage(int[][] A){
        int height=A.length;
        int width=A[0].length;
        int[][] result=new int[height][width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                result[i][j]=1-A[i][width-j-1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(flipAndInvertImage(new int[][]{{0,0,1,0},{1,0,0,1}}));
    }
}
