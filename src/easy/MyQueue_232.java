package easy;

import java.util.Stack;

public class MyQueue_232<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public MyQueue_232(Stack<T> stack1, Stack<T> stack2) {
        this.stack1 = stack1;
        this.stack2 = stack2;
    }



    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1=new Stack<T>();
        stack2=new Stack<T>();
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       // stack1
        return 0;
    }

    /** Get the front element. */
    public int peek() {
        return 0;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return true;
    }


}
