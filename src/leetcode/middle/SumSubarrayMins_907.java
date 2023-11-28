package leetcode.middle;

import java.util.Deque;
import java.util.LinkedList;

public class SumSubarrayMins_907 {

    public int sumSubarrayMins(int[] arr) {
        //todo:dcl
        Deque<Integer> stack = new LinkedList<>();
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
                stack.poll();
            }
            left[i] = i - (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 0 && arr[i] < arr[stack.peek()]) {
                stack.poll();
            }
            right[i] = (stack.isEmpty() ? n : stack.peek()) - i;
            stack.push(i);
        }
        long res = 0;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            res =( res + (long) arr[i] * left[i] * right[i] )% mod;
        }
        return (int) res;
    }

}
