package sort;

public class ArraySort {
    public static void buddleSort(int[] array){
        int length = array.length;
        for (int i = 0; i <length; i++) {
            boolean flag=false;
            for (int j = 1; j <length-i; j++) {
                if(array[j]<array[j-1]){
                    int temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
        String str="a";
    }


    //region heap sort region
    // todo : complete the algorithm
    public static void heapSort(int[] array) {
        int length = array.length;
        buildHeap(array,length);

    }

    private static void buildHeap(int[] array, int length) {
        for (int i = length-1; i >0 ; i--) {

        }
    }

    private static void doBuildHeap(int[] array,int i){

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    //endregion


    public static void fastSort(int[] array) {
        doFastSort(array, 0, array.length - 1);
    }

    private static void doFastSort(int[] array, int begin, int end) {
        if(begin>=end){
            return;
        }
        int base = array[begin];
        int left = begin;
        int right = end;
        while (left < right) {
            while (base < array[right] && left < right) {
                right--;
            }
            if (left < right) {
                array[left]=array[right];
                left++;
            }
            while(base>array[left]&&left<right){
                left++;
            }
            if(left<right){
                array[right]=array[left];
                right--;
            }
        }
        array[left]=base;
        doFastSort(array, begin, left-1);
        doFastSort(array, left+1, end);
    }

}
