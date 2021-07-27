package algorithm;

public class ArraySort {

    /**
     * 冒泡排序
     * @param array
     */
    public static void buddleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param array
     */
    public static void selectionSort(int[] array){
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int min=i;
            for (int j = i+1; j < length; j++) {
                if(array[j]<array[min])
                    min=j;
            }
            if(min!=i){
                int temp=array[min];
                array[min]=array[i];
                array[i]=temp;
            }
        }
    }

    /**
     * 插入排序
     * @param array
     */
    public static void insertSort(int[] array){
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int cur=array[i];
            int position=i;
            while(position>0&&array[position-1]>cur){
                array[position]=array[position-1];
                position--;
            }
            array[position] = cur;
        }
    }


    /**
     * 归并排序
     * @param array
     */
    public static void mergeSort(int[] array) {
        doMergeSort(array, 0, array.length - 1);
    }


    private static void doMergeSort(int[] array, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2 ;
            doMergeSort(array, begin, mid);
            doMergeSort(array, mid + 1, end);
            mergeTwoArray(array, begin, mid, mid + 1, end);
        }
    }


    private static void mergeTwoArray(int[] array, int left, int right, int begin, int end) {
        int[] temp = new int[end - left + 1];
        int index = 0;
        int cur1 = left;
        int cur2 = begin;
        while (cur1 <= right && cur2 <= end) {
            if (array[cur1] < array[cur2]) {
                temp[index++] = array[cur1++];
            } else {
                temp[index++] = array[cur2++];
            }
        }
        while(cur1<=right){
            temp[index++]=array[cur1++];
        }
        while(cur2<=end){
            temp[index++]=array[cur2++];
        }
        for (int i = left; i <= end; i++) {
            array[i] = temp[i - left];
        }
    }


    /**
     * 希尔排序
     * @param array
     */
    public static void shellSort(int[] array) {
        int n = array.length;
        for (int step = n / 2; step > 0; step = step / 2) {
            for (int i = step; i < n; i++) {
                //对每一个数进行插入排序
                for (int m = i - step; m >= 0; m -= step) {
                    if (array[m] > array[m + step]) {
                        int temp = array[m];
                        array[m] = array[m + step];
                        array[m + step] = temp;
                    }
                }
            }

        }
    }

    /**
     * 快排
     * @param a
     */
    public static void fastSort(int[] a){
        recursionSort(a,0,a.length-1);
    }


    private static int doFastSort(int[] a, int begin, int end) {
        int base = a[begin];
        while (begin < end) {
            while (begin < end && a[end] >= base) {
                end--;
            }
            if (begin < end) {
                a[begin] = a[end];
            }
            while (begin < end && a[begin] < base) {
                begin++;
            }
            if (begin < end) {
                a[end] = a[begin];
            }
        }
        a[end] = base;
        return end;
        //end 左右已经排好序
    }

    private static void recursionSort(int[] a, int begin, int end) {
        if (begin < end) {
            int i = doFastSort(a, begin, end);
            recursionSort(a, i + 1, end);
            recursionSort(a, begin, i - 1);
        }
    }


}
