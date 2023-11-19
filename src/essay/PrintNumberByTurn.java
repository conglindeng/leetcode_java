package essay;

//        new PrintNumberByTurn().printNumberByTurn(10000);
//        new PrintNumberByTurn_Semaphore().printNumberByTurn(100);
//        new PrintNumberByTurn_Condition().printNumberByTurn(10);

/**
 * 写两个线程打印 1-n，一个线程打印奇数，一个线程打印偶数
 */
public class PrintNumberByTurn {

    private static final Object lock = new Object();

    public void printNumberByTurn(int n) {
        final int[] i = {1};
        new Thread(() -> {
            while (i[0] < n) {
                synchronized (lock) {
                    while (i[0] % 2 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + i[0]);
                    i[0] += 1;
                    lock.notifyAll();

                }
            }
        }, "print odd number").start();

        new Thread(() -> {
            while (i[0] < n) {
                synchronized (lock) {
                    while (i[0] % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + i[0]);
                    i[0] += 1;
                    lock.notifyAll();

                }
            }
        }, "print even number").start();


    }

}
