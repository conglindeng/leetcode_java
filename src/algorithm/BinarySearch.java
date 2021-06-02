package algorithm;

public class BinarySearch {
    private BinarySearch() {
    }

    public static int binarySearch(int[] array,int target){
        int result=-1;
        int left=0;
        int right=array.length-1;
        int middle;
        while(left<=right){
            middle=(left+right)/2;
            if(array[middle]==target){
                result=middle;
                break;
            }
            else if(array[middle]<target){
                left=middle+1;
            }else{
                right=middle-1;
            }

        }
        return result;
    }
}
