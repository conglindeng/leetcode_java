package leetcode.easy;

public class PeakIndexInMountainArray_852 {
    public static int peakIndexInMountainArray(int[] arr) {
        int length = arr.length;
        int left=1,right=length-2,result=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]>=arr[mid-1]){
                result=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        return result;
    }
}
