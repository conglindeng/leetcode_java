

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinalDemo {

    private static int count = 0;

    private static final ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        H2O h2O = new H2O();
        H2O h2O_2 = new H2O();
        System.out.println(h2O_2.hashCode());
        System.out.println(h2O.hashCode());
        for (int i = 0; i < 20; i++) {
            pool.submit(() -> {
                h2O.oxygen(() -> {
                    System.out.println(" O ");
                });
            });
            pool.submit(() -> {
                h2O.hydrogen(() -> {
                    System.out.println(" H ");
                });
            });
        }
        pool.shutdown();
    }
}

class H2O1 {

    //氧原子的数量
    private final AtomicInteger oxygen = new AtomicInteger(0);
    //氢原子的数量
    private final AtomicInteger hydrogen = new AtomicInteger(0);
    private Lock lock = new ReentrantLock(false);
    private Condition condition = lock.newCondition();

    public void hydrogen(Runnable releaseHydrogen) {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        try {
            lock.lock();
            //产生了两个H原子，就需要等O原子产生
            while (hydrogen.get() == 2) {
                condition.await();
            }
            hydrogen.incrementAndGet();
            releaseHydrogen.run();
            if (oxygen.get() == 2 && hydrogen.get() == 2) {
                oxygen.set(0);
                hydrogen.set(0);
            }
            condition.signalAll();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        try {
            lock.lock();
            while (oxygen.get() == 2) {
                condition.await();
            }
            oxygen.incrementAndGet();
            releaseOxygen.run();
            if (oxygen.get() == 2 && hydrogen.get() == 2) {
                oxygen.set(0);
                hydrogen.set(0);
            }
            condition.signalAll();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }
}


class H2O {

    private volatile int hydrogen;
    private volatile int oxygen;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        synchronized (this) {
            if (hydrogen == 2) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            hydrogen++;
            releaseHydrogen.run();
            if (hydrogen == 2 && oxygen == 1) {
                hydrogen = 0;
                oxygen = 0;
                notifyAll();
            }
        }
    }

    public void oxygen(Runnable releaseOxygen) {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        synchronized (this) {
            if (oxygen == 1) {
                try {
                    wait();//O在waitSet里，释放锁
                    //sync
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            oxygen++;
            releaseOxygen.run();
            if (hydrogen == 2 && oxygen == 1) {
                hydrogen = 0;
                oxygen = 0;
                notifyAll();
            }
        }
    }
}


