package thread.homework1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class CountDownLatch1 {
    private static CountDownLatch c = new CountDownLatch(1);

    private static Semaphore semaphore=new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        semaphore();
    }

    public void coundDownLatch() throws InterruptedException {
        new Thread(() -> {
            System.out.println("thread start");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("thread end");
            c.countDown();
        }).start();
        c.await();
        System.out.println("main end");
    }

    public static void join() throws InterruptedException {
        Thread thread = new Thread(() -> {

            System.out.println("thread start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread end");
        });
        thread.start();
        thread.join();
        System.out.println("main end");
    }
    public static void semaphore() throws InterruptedException {
        Thread thread = new Thread(() -> {

            System.out.println("thread start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread end");
            semaphore.release();
        });
        thread.start();
        semaphore.acquire();
        System.out.println("main end");
    }



}
