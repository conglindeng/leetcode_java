package thread.homework1;

public class SychornizedTest {
    final static Object lock=new Object();
    public static void main(String[] args) throws Exception {

        Thread t=new Thread(()->{
            synchronized (lock){
                System.out.println("t start");
                System.out.println("t end");
                lock.notifyAll();
            }
        },"SychornizedTest");
        t.start();
        System.out.println("main start");
        synchronized (lock){
            lock.wait();
            System.out.println("main end");
        }
    }
}
