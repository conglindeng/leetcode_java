package leetcode.difficult;

import leetcode.middle.SubarraySum_560;

public class NumSubmatrixSumTarget_1074 {
    public int numSubmatrixSumTarget(int[][] matrix,int target){
        int height=matrix.length;
        int width=matrix[0].length;
        int result=0;
        for (int i = 0; i < height; i++) {
            int[] sum=new int[width];
            for (int j = i; j < height; j++) {
                for (int k = 0; k < width; k++) {
                    sum[k]+=matrix[j][k];
                }
                result+=SubarraySum_560.subarraySum(sum,target);
            }
        }

        return result;
    }
}
