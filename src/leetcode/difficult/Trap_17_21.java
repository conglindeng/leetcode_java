package leetcode.difficult;

import java.util.Deque;
import java.util.LinkedList;

public class Trap_17_21 {
    public static int trap(int[] height) {
        int length = height.length;
        int leftMax[] = new int[length];
        int rightMax[] = new int[length];
        for (int i = 0; i < length; i++) {
            leftMax[i] = Math.max(height[i], i - 1 < 0 ? 0 : leftMax[i - 1]);
        }
        for (int j = length-1; j >= 0; j--) {
            rightMax[j] = Math.max(height[j], j + 1 >= length ? 0 : rightMax[j + 1]);
        }
        int result = 0;
        for (int m = 0; m < length; m++) {
            int left=leftMax[m];
            int right=rightMax[m];
            int min = Math.min(left, right);
            if(min>height[m]) {
                result+= min -height[m];
            }
        }
        return result;
    }

    public int trap2(int[] height){
        Deque<Integer> stack=new LinkedList<>();

        return -1;
    }



    public static void main(String[] args) {
        System.out.println(trap(new int[]{2,0,2}));
    }
}
