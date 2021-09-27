package util;

public class Heap {

    private int size = 0;
    private int maxCount;
    private int[] queue;

    public Heap(int size) {
        this.size = 0;
        maxCount = size;
        queue = new int[size];
    }

    public void add(int e) {
        if (size == queue.length) {
            //扩容
            return;
        }
        if (size == 0) {
            queue[size++] = e;
            return;
        }
        //queue[size] = e;
        size++;
        siftUp(size - 1, e);
    }

    public int poll() {
        if (size == 0) {
            return -1;
        }
        int result = queue[0];
        int last = queue[--size];
        siftDown(0, last);
        return result;
    }

    private void siftUp(int index, int e) {
        int parent;
        while (index > 0) {
            parent = (index - 1) >>> 1;
            if (queue[parent] < e) {
                break;
            }
            queue[index] = queue[parent];
            index = parent;
        }
        queue[index] = e;
    }

    private void siftDown(int index, int e) {
        int half = size >>> 1;
        while (index < half) {
            int next = (index << 1) + 1;
            int right = next + 1;
            int data = queue[next];
            if (right < size && data > queue[right]) {
                data = queue[right];
                next = right;
            }
            if (data > e) {
                break;
            }
            queue[index] = data;
            index = next;
        }
        queue[index] = e;
    }
}
