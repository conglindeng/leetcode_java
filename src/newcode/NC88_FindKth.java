package newcode;

public class NC88_FindKth {

    /**
     * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
     * <p>
     * 给定一个整数数组a,同时给定它的大小n和要找的K(1<=K<=n)，请返回第K大的数(包括重复的元素，不用去重)，保证答案存在。
     * <p>
     * 示例1
     * 输入：
     * [1,3,5,2,2],5,3
     * 复制
     * 返回值：
     * 2
     */
    public int findKth(int[] a, int n, int K) {
        // write code here
        if (K > n) {
            return -1;
        }
        return recursionSort(a, 0, n - 1, K - 1);
    }


    private int fastSort(int[] a, int begin, int end) {
        int base = a[begin];
        while (begin - end < 0) {
            while (begin < end && a[end] <= base) {
                end--;
            }
            if (begin < end) {
                a[begin] = a[end];
            }
            while (begin < end && a[begin] > base) {
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

    private int recursionSort(int[] a, int begin, int end, int k) {
        if (begin <= end) {
            int i = fastSort(a, begin, end);
            if (i == k) {
                return a[k];
            }
            if (i < k) {
                return recursionSort(a, i + 1, end, k);
            } else {
                return recursionSort(a, begin, i - 1, k);
            }
        }
        return -1;
    }

}
