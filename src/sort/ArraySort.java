package sort;

public class ArraySort {
    public static void buddleSort(int[] array){
        int length = array.length;
        for (int i = 0; i <length; i--) {
            for (int j = 0; j <i; j++) {
                //if()
            }
        }
    }


    //region heap sort region
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

    private static void swap(int[] array, int i , int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    //endregion
}
