package thread.example;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockTest {
    private static Object resource_a = new Object();
    private static Object resource_b = new Object();

    public static void main(String[] args) {
        ThreadLocal threadLocal=new ThreadLocal();
        threadLocal.set("oo");
        threadLocal.get();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(()->{
            return "a";
        });


        //System.out.println(ClassLayout.parseClass(Object.class).toPrintable());
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource_a) {
                    synchronized (resource_b) {

                    }
                }
            }
        },"thread_A");
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource_b) {


                    synchronized (resource_a) {

                    }

                }
            }
        },"thread_B");
        threadA.start();
        threadB.start();

    }
}
