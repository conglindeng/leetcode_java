package thread;

import java.util.concurrent.CountDownLatch;

public class SyncTest {

    private static final Object lock = new Object();

    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }


    public static void main(String[] args) throws InterruptedException {
        SyncTest syncTest = new SyncTest();
        syncTest.setI(0);
        int threadCount = 50;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int j = 0; j < threadCount; j++) {
            new Thread(() -> {
                for (int m = 0; m < 1000; m++) {
                    synchronized (lock) {
                        syncTest.setI(syncTest.getI() + 1);
                    }
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(syncTest.getI());
    }
}