package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class NoSecurityThread {
    private static int count=0;
    private static CountDownLatch semaphore=new CountDownLatch(10);

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    count++;
                }
                semaphore.countDown();
            },"thread_"+i).start();
        }
        semaphore.await();
        System.out.println(count);
    }
}
