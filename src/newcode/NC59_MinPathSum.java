package newcode;

public class NC59_MinPathSum {
    /**
     *
     * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {
        // write code here
        if(matrix==null||matrix.length==0){
            return 0;
        }
        int width = matrix[0].length;
        int[] dp=new int[width +1];
        for(int i=0;i<width;i++){
            dp[i+1]=dp[i]+matrix[0][i];
        }
        int height = matrix.length;
        for(int i=1;i<height;i++){
            for(int j=0;j<width;j++){
                if(j==0)
                    dp[j+1]=dp[j+1]+matrix[i][j];
                else
                    dp[j+1]=Math.min(dp[j],dp[j+1])+matrix[i][j];
            }
        }

        return dp[width];
    }
}
