package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CasQueueByAtomicRefrence {

    private AtomicReference<Node> head;
    private AtomicReference<Node> tail;
    private AtomicInteger size = new AtomicInteger(0);

    public CasQueueByAtomicRefrence() {
        head = new AtomicReference<>(null);
        tail = new AtomicReference<>(null);
    }

    public void push(int val) {
        Node newNode = new Node(val);
        Node oldNode = tail.getAndSet(newNode);
        oldNode.next = newNode;
        size.incrementAndGet();
    }

    public int poll() {
        Node nextNode, headNode;
        do {
            headNode = head.get();
            nextNode = headNode.next;
        } while (nextNode != null && !head.compareAndSet(headNode, nextNode));
        if (nextNode == null) {

        }
        size.decrementAndGet();
        return nextNode.val;
    }


    private static class Node {
        int val;
        volatile Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
