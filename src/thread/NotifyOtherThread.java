package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class NotifyOtherThread {
    //public static final Semaphore semp=new Semaphore(1);
    private static final CountDownLatch countDown=new CountDownLatch(1);
    public static final Object lock =new Object();

    public static void main(String[] args) {
/*
        countDown.countDown();
        countDown.await();
*/

        new Thread(() -> {
            synchronized (lock){
                while (true) {
                    try {
                        lock.wait();
                        System.out.println("B ---> 收到...");
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(()->{
            synchronized (lock){
                while (true) {
                    for (int i = 1; i <= 10; i++) {
                        if (i == 5) {
                            try {
                                lock.notifyAll();
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            continue;
                        }
                        System.out.println("A ---> " + i);
                    }
                    System.out.println("---------------------------------");
                }
            }
        },"thread1").start();

    }
}
