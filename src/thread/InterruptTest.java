package thread;

public class InterruptTest {

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                System.out.println(" before wait " + " interrupt : " + Thread.currentThread().isInterrupted());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(" after wait " + " interrupt : " + Thread.currentThread().isInterrupted());
                    throw new RuntimeException(e);
                }
                System.out.println(" ok,done it ");
            }
        });
        thread.start();

        Thread.sleep(2000L);
        System.out.println(" before interrupt " + " interrupt : " + thread.isInterrupted());
        thread.interrupt();
        System.out.println(" after interrupt " + " interrupt : " + thread.isInterrupted());
        Thread.sleep(100L);
//        synchronized (lock) {
//            lock.notify();
//        }

    }

}
