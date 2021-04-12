package thread.homework1;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    public static void main(String[] args) {
        final AtomicInteger integer=new AtomicInteger(0);
        Thread t=new Thread(()->{
            System.out.println("thread start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                integer.incrementAndGet();
                System.out.println("thread end");
            }
        });
        System.out.println("main start");
        t.start();
        while(integer.get()!=1){

        }
        System.out.println("main end");
    }
}
