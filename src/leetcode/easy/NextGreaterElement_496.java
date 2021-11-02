package leetcode.easy;

import java.util.*;

public class NextGreaterElement_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[] res = new int[length];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int cur = nums2[i];
            while (!stack.isEmpty() && cur > stack.peek()) {
                stack.pop();
            }
            map.put(cur, stack.isEmpty() ? -1 : stack.peek());
            stack.push(cur);
        }
        for (int i = 0; i < length; i++) {
            res[i]=map.get(nums1[i]);
        }
        return res;
    }

    public int[] nextGreaterElement_ans(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }




    private int findFirstMoreThan(int base, int[] arr) {
        return -1;
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int length = arr.length;
        //先自底向上不停的构建出一个堆
        for (int i = 1; i < length; i++) {
            shiftUp(i, arr);
        }
        //再不停将栈顶元素弹出，弹出后将最后一个元素往前提，自顶向下调整堆结构
        for (int i = length - 1; i > 1; i--) {
            int temp = arr[0];

            shiftDown(arr, 0, i - 1);

            arr[i] = temp;
        }
    }


    private static void shiftUp(int i, int[] arr) {
        int data = arr[i];
        while (i > 0) {
            int parent = i >> 1;
            if (arr[parent] > data) {
                break;
            }
            arr[i] = arr[parent];
            i = parent;
        }
        arr[i] = data;
    }

    private static void shiftDown(int[] arr, int begin, int capcity) {
        int condidate = arr[capcity + 1];
        int half = capcity >> 1;
        while (begin < half) {
            int index = (begin << 1) + 1;
            int right = index + 1;
            int value = arr[index];
            if (right <= capcity && arr[right] > value) {
                index = right;
                value = arr[index];
            }
            if (condidate > value) {
                break;
            }
            arr[begin] = value;
            begin = index;
        }
        arr[begin] = condidate;
    }

}
