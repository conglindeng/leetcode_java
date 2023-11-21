package essay;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer {
    /*
     * 1. data queue
     * 2. consumer collections
     * 3. producer collections
     * 4. lock to assure concurrence safety
     * wakeup consumer when the data queue has data
     * wakeup producer when create new position
     */

    private final static ReentrantLock lock = new ReentrantLock();
    private final static Condition empty = lock.newCondition();
    private final static Condition full = lock.newCondition();

    // to avoid unnecessary lock race,
    // can split lock to putLock & putLock, such as LinkedBlockingQueue


    private final int[] data;

    private int putIndex;

    public ProducerAndConsumer(int capacity) {
        this.putIndex = 0;
        this.data = new int[capacity];
    }

    public void enQueue(int val) {
        lock.lock();
        try {
            while (putIndex == data.length) {
                empty.await();
            }
            data[putIndex] = val;
            putIndex++;
            full.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public int deQueue() {
        lock.lock();
        try {
            while (putIndex == 0) {
                full.await();
            }
            int val = data[putIndex - 1];
            putIndex--;
            empty.signalAll();
            return val;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
