package leetcode.middle;

public class FrontMiddleBackQueue_1670_Deque {

    Node head;
    Node tail;
    int size;

    public FrontMiddleBackQueue_1670_Deque() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public void pushFront(int val) {
        Node node = new Node(val);

        node.next = head.next;
        head.next.pre = node;

        node.pre = head;
        head.next = node;

        updateSize(1);
    }

    public void pushMiddle(int val) {
        if (size <= 1) {
            pushFront(val);
            return;
        }
        Node middleNode = findMiddleNode();
        Node node = new Node(val);

        middleNode.pre.next = node;
        node.pre = middleNode.pre;
        node.next = middleNode;
        middleNode.pre = node;

        updateSize(1);
    }

    public void pushBack(int val) {
        Node node = new Node(val);

        node.pre = tail.pre;
        tail.pre.next = node;

        node.next = tail;
        tail.pre = node;

        updateSize(1);
    }

    public int popFront() {
        if (size == 0) {
            return -1;
        }
        Node res = head.next;

        head.next = res.next;
        res.next.pre = head;

        res.next = null;
        res.pre = null;

        updateSize(-1);
        return res.val;
    }

    public int popMiddle() {
        if (size == 0) {
            return -1;
        }
        if (size <= 2) {
            return popFront();
        }
        Node middleNode = findMiddleNode();
        if (size % 2 == 0) {
            middleNode = middleNode.pre;
        }
        if (middleNode == tail) {
            return popFront();
        }
        middleNode.pre.next = middleNode.next;
        if (middleNode.next != null) {
            middleNode.next.pre = middleNode.pre;
        }
        middleNode.pre = null;
        middleNode.next = null;
        updateSize(-1);
        return middleNode.val;
    }

    public int popBack() {
        if (size == 0) {
            return -1;
        }
        Node res = tail.pre;

        tail.pre = res.pre;
        res.pre.next = tail;

        res.next = null;
        res.pre = null;

        updateSize(-1);
        return res.val;
    }

    private Node findMiddleNode() {
        Node temp = head.next;
        for (int i = 0; i < size / 2; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private void updateSize(int add) {
        size += add;
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

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such: FrontMiddleBackQueue obj = new
 * FrontMiddleBackQueue(); obj.pushFront(val); obj.pushMiddle(val); obj.pushBack(val); int param_4 = obj.popFront(); int
 * param_5 = obj.popMiddle(); int param_6 = obj.popBack();
 */