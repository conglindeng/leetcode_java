package newcode;

import java.util.Deque;
import java.util.LinkedList;

public class NC90_MinStack {
    Deque<Integer> work;
    Deque<Integer> min;

    public NC90_MinStack() {
        work = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int node) {
        work.push(node);
        if(min.isEmpty()){
            min.push(node);
        }else{
            if(min.peek()<node){
                min.push(min.peek());
            }else{
                min.push(node);
            }
        }
    }

    public void pop() {
        work.pop();
        min.pop();
    }

    public int top() {
        if(work.isEmpty()){
            return -1;
        }
        return work.peek();
    }

    public int min() {
        if(min.isEmpty()){
            return -1;
        }
        return min.peek();
    }

    private static class Node {
        Node pre;
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
