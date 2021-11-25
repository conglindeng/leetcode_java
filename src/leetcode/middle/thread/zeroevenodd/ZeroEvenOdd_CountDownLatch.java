package leetcode.middle.thread.zeroevenodd;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;

public class ZeroEvenOdd_CountDownLatch {
    private int n;

    private final CountDownLatch zero=new CountDownLatch(0);
    //奇数
    private final CountDownLatch odd=new CountDownLatch(0);
    //偶数
    private final CountDownLatch even=new CountDownLatch(0);



    public ZeroEvenOdd_CountDownLatch(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            printNumber.accept(0);
            if ((i & 1) == 1) {
                odd.countDown();
            } else {

            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {
                even.await();
                printNumber.accept(i);
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i ++) {
            if((i & 1) == 1){
                printNumber.accept(i);
            }
        }
    }
}
