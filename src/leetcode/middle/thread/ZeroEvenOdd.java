package leetcode.middle.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    //零
    private final Semaphore zeroLock = new Semaphore(1);
    //偶数
    private final Semaphore evenLock = new Semaphore(0);
    //奇数
    private final Semaphore oddLock = new Semaphore(0);

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroLock.acquire();
            printNumber.accept(0);
            if (i % 2 != 0) {
                oddLock.release();
            } else {
                evenLock.release();
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            evenLock.acquire();
            printNumber.accept(i);
            zeroLock.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            oddLock.acquire();
            printNumber.accept(i);
            zeroLock.release();
        }
    }
}