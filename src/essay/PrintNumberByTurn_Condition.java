package essay;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 写两个线程打印 1-n，一个线程打印奇数，一个线程打印偶数
 */
public class PrintNumberByTurn_Condition {

    private static final Lock lock = new ReentrantLock();
    private static final Condition condition_1 = lock.newCondition();
    private static final Condition condition_2 = lock.newCondition();

    public void printNumberByTurn(int n) {
        final int[] i = {1};
        new Thread(() -> {
            while (i[0] < n) {
                lock.lock();
                try {
                    while ((i[0] & 1) == 1) {
                        condition_1.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + i[0]);
                    i[0]++;
                    condition_2.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }, "thread even ").start();

        new Thread(() -> {
            while (i[0] < n) {
                lock.lock();
                try {
                    while ((i[0] & 1) == 0) {
                        condition_2.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + i[0]);
                    i[0]++;
                    condition_1.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }, "thread odd ").start();


    }

}
