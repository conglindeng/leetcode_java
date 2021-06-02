package leetcode.middle;

import algorithm.BinarySearch;

public class SearchMatrix_74 {
    public boolean searchMatrix(int[][] matrix,int target){
        int row=binarySearchFirstColumn(matrix,target);
        if(row==-1){
            return false;
        }

        return BinarySearch.binarySearch(matrix[row],target)==-1;
    }



    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
