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

    public CasQueue() {
        tail = new Node(-1);
        head = new Node(-1);
    }

    public void push() {
        return ;
    }


    public int poll(int val) {
        return -1;
    }

    static class Node {
        int val;
        volatile Node next;

        public Node(int val) {
            this.val = val;
        }
    }


}
