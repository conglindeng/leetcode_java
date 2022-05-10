package leetcode.easy;

import java.util.Stack;

public class MyQueue_232 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    int size = 0;

    public MyQueue_232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }


    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (size != 0) {
            if (stack1.isEmpty()) {
                for (int i = 0; i < size; i++) {
                    stack1.push(stack2.pop());
                }
            }
        }
        stack1.push(x);
        size++;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.isEmpty()) {
            for (int i = 0; i < size; i++) {
                stack2.push(stack1.pop());
            }
        }
        size--;
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stack2.isEmpty()) {
            for (int i = 0; i < size; i++) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return size == 0;
    }


}
