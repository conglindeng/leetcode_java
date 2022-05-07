package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

class MyStack_225 {

    Queue<Integer> first;
    Queue<Integer> second;
    int size;

    public MyStack_225() {
        first = new LinkedList<>();
        second = new LinkedList<>();
        size = 0;
    }

    public void push(int x) {
        if (size == 0) {
            first.offer(x);
        } else {
            if (first.isEmpty()) {
                second.offer(x);
            } else {
                first.offer(x);
            }
        }
        size++;
    }

    public int pop() {
        Integer res = null;
        if (first.isEmpty()) {
            for (int i = 1; i < size; i++) {
                first.offer(second.poll());
            }
            res = second.poll();
        } else {
            for (int i = 1; i < size; i++) {
                second.offer(first.poll());
            }
            res = first.poll();
        }
        size--;
        return res;
    }

    public int top() {
        Integer res = null;
        if (first.isEmpty()) {
            for (int i = 1; i < size; i++) {
                first.offer(second.poll());
            }
            res = second.poll();
            first.offer(second.poll());
        } else {
            for (int i = 1; i < size; i++) {
                second.offer(first.poll());
            }
            res = first.peek();
            second.offer(first.poll());
        }
        return res;
    }

    public boolean empty() {
        return size == 0;
    }
}