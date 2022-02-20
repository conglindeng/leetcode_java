package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class PancakeSort_969 {
    public List<Integer> pancakeSort(int[] arr) {
        int length = arr.length;
        List<Integer> res = new ArrayList<>();
        for (int n = length - 1; n > 0; n--) {
            int max = 0;
            //1.找到当前0至n索引中最大的值对应的索引idx
            //2.若idx等于n，则进行下次循环
            //3.若idx不等于n，则先将此最大值以idx为索引进行煎饼旋转
            //                 再以n为索引进行煎饼旋转
            for (int i = 1; i <= n; i++) {
                if (arr[i] > arr[max]) {
                    max = i;
                }
            }
            if (max == n) {
                continue;
            }
            swap(arr, max);
            swap(arr, n);
            res.add(max);
            res.add(n);
        }
        return res;
    }

    private void swap(int[] arr, int idx) {
        for (int i = 0; i <= idx / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[idx - i];
            arr[idx - i] = temp;
        }
    }
}
