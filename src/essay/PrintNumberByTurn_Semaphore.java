package essay;

import java.util.concurrent.Semaphore;

/**
 * 写两个线程打印 1-n，一个线程打印奇数，一个线程打印偶数
 */
public class PrintNumberByTurn_Semaphore {

    private static final Semaphore lock = new Semaphore(1);

    public void printNumberByTurn(int n) {
        final int[] i = {1};
        new Thread(() -> {
            for (; ; ) {
                lock.acquire();
            }
        }, "print odd number").start();

        new Thread(() -> {
            for (; ; ) {

            }
        }, "print even number").start();


    }

}
