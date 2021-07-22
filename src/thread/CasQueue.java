package thread;

import sun.misc.Unsafe;

public class CasQueue {

    private static final Unsafe unsafe;
    private static final long tailoffset;
    private static final long headoffset;

    static {
        try {
            unsafe = Unsafe.getUnsafe();
            Class<CasQueue> clazz = CasQueue.class;
            tailoffset = unsafe.objectFieldOffset(clazz.getDeclaredField("tail"));
            headoffset = unsafe.objectFieldOffset(clazz.getDeclaredField("head"));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    Node tail;
    Node head;

//    public CasQueue() {
//        tail = new Node(-1);
//        head = new Node(-1);
//    }

    public int dequeue() {
        for (; ; ) {

        }
    }


    public boolean enqueue(int val) {
        for( ; ; ){

        }
    }

    static class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }


}
