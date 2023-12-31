package essay;

import java.util.concurrent.Semaphore;

/**
 * 写两个线程打印 1-n，一个线程打印奇数，一个线程打印偶数
 */
public class PrintNumberByTurn_Semaphore {

    private static final Semaphore odd = new Semaphore(1);
    private static final Semaphore even = new Semaphore(0);

    public void printNumberByTurn(int n) {
        final int[] i = {1};
        new Thread(() -> {
            while (i[0] < n) {
                try {
                    even.acquire();
                    System.out.println(Thread.currentThread().getName() + " " + i[0]);
                    i[0]++;
                    odd.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "thread even ").start();

        new Thread(() -> {
            while (i[0] < n) {
                try {
                    odd.acquire();
                    System.out.println(Thread.currentThread().getName() + " " + i[0]);
                    i[0]++;
                    even.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        }, "thread odd ").start();


    }

}
