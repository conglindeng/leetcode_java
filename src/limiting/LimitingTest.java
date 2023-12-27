package limiting;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import limiting.model.Request;

public class LimitingTest {

    public static void main(String[] args) throws Throwable {

        FixedWindow fixedWindow = new FixedWindow(10, 1000L, TimeUnit.MILLISECONDS);

        SlidingWindow slidingWindow = new SlidingWindow(2000L, 10);

        TokenBucket tokenBucket = new TokenBucket(100, 100L);

        int threadCount = 50;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                Random random = new Random();
                for (int j = 0; j < 10; j++) {
                    int space = random.nextInt(6);
                    try {
                        Thread.sleep(space * 300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    tokenBucket.requestLimit(new Request("111", "192.168.0.1"));
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();

    }

}
