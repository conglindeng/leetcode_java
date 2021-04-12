package thread.homework1;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        final Semaphore semaphore=new Semaphore(0);
        Thread t=new Thread(()->{
            System.out.println("t start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t end");
            semaphore.release();
        });
        t.start();

        System.out.println("main start");
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}
