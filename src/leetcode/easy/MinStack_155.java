package leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack_155 {

    private Deque<Integer> nums;
    private Deque<Integer> mins;

    public MinStack_155() {
        nums = new LinkedList<>();
        mins = new LinkedList<>();
    }

    public void push(int val) {
        nums.push(val);
        if (!mins.isEmpty()) {
            Integer peek = mins.peek();
            if (peek < val) {
                mins.push(peek);
            } else {
                mins.push(val);
            }
        } else {
            mins.push(val);
        }
    }

    public void pop() {
        mins.pop();
        nums.pop();
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
