package leetcode.middle;

public class MyCircularQueue_622 {

    // with array

    Node head;
    Node tail;
    int capacity;
    int size;

    public MyCircularQueue_622(int k) {
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            head.next = tail;
            head.pre = tail;
        } else {
            newNode.next = head;
            head.pre = newNode;
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
        }
        ++size;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node next = head.next;
            head.next = null;
            head.pre = null;
            tail.next = next;
            next.pre = tail;
            head = next;
        }
        size--;
        //randomly delete a number
        return true;
    }

    public int Front() {
        //get head
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }

    public int Rear() {
        //get tail
        if (isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return capacity == size;
    }

    static class Node {

        Node pre;
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

}