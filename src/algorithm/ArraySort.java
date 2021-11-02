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

    /**
     * 根据size的中位数将数组分为两个部分，左边、右边
     * 排序左边
     * 排序右边
     * 合并左右已排序数组
     */
    private static void doMergeSort(int[] array, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2 ;
            doMergeSort(array, begin, mid);
            doMergeSort(array, mid + 1, end);
            mergeTwoArray(array, begin, mid, mid + 1, end);
        }
    }

    /**
     * 合并左右两个已排序数组
     */
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

    /**
     * 堆排
     * @param array
     */
    public static void heapSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        //buid heap
        int length = array.length;
        for (int i = 1; i < length; i++) {
            siftUp(i, array, array[i]);
        }
        int size = length;
        //不停的弹出堆顶元素，放在堆后的第一个位置，并不断调整堆结构
        for (int i = length - 1; i > 0; i--) {
            int temp = array[0];
            siftDown(0, array, size--, array[i]);
            array[i] = temp;
        }
    }

    /**
     * 自底向上进行位置的调整
     * @param index 最后一个位置
     * @param array 堆数组
     * @param data 待调整的数据
     */
    private static void siftUp(int index, int[] array, int data) {
        //一直的父节点进行比较
        // 若父节点大于data，则将父节点的值挪到当前index
        // 否则说明找到当前应该放置的位置了
        while (index > 0) {
            int parent = index >> 1;
            if (array[parent] < data) {
                break;
            }
            array[index] = array[parent];
            index = parent;
        }
        array[index] = data;
    }

    private static void siftDown(int index, int[] array, int size, int data) {
        int half = size >>> 1;
        while (index < half) {
            //从左右子节点中找寻向上升级符合要求的候选node，默认先给left节点
            int condidate = (index << 1) + 1;
            int right = condidate + 1;
            int condidateVal = array[condidate];
            //如果right节点的值小于左边的节点，说明候选node应该为right节点
            if (right < size && array[right] < condidateVal) {
                condidateVal = array[right];
                condidate = right;
            }
            //此时再和最后一个下沉元素比较，如果最后一个下沉元素还要小，则最后一个元素的位置就是在第0位
            if (data < condidateVal) {
                break;
            }
            array[index] = condidateVal;
            index = condidate;
        }
        array[index] = data;
    }

}
