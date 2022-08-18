package leetcode.middle;

public class MyCircularDeque_641 {

    int capacity;
    int size;
    int[] nums;
    int front;
    int last;

    public MyCircularDeque_641(int k) {
        this.capacity = k;
        this.nums = new int[capacity];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (!isEmpty()) {
            front = (front - 1 + capacity) % capacity;
        }
        nums[front] = value;
        ++size;
        return true;

    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (!isEmpty()) {
            last = (last + 1) % capacity;
        }
        nums[last] = value;
        ++size;
        return true;
    }


    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (size != 1) {
            front = (front + 1) % capacity;
        }
        --size;
        return true;

    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (size != 1) {
            last = (last - 1 + capacity) % capacity;
        }
        --size;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return nums[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return nums[last];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */