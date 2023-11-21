import essay.LoadBalance_Weight_Round_Basic;
import essay.LoadBalance_Weight_Round_Sleek;
import essay.ProducerAndConsumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import javafx.util.Pair;

public class ThreadMain {

    private static final Object lock_a = new Object();
    private static final Object lock_b = new Object();

    public static void main(String[] args) throws InterruptedException {

    }


    public static void produceAndConsumerTest() throws InterruptedException {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer(5);
        int count = 1000;
        List<Integer> objects = Collections.synchronizedList(new ArrayList<>(count));
        for (int i = 0; i < count; i++) {
            int finalI = i;
            new Thread(() -> {
                producerAndConsumer.enQueue(finalI);
            }, " producer " + i).start();
        }
        CountDownLatch countDownLatch=new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 200; j++) {
                    int val = producerAndConsumer.deQueue();
                    objects.add(val);
                    System.out.println(" poll out : " + val);
                }
                countDownLatch.countDown();
            }, "consumer " + i).start();
        }
        countDownLatch.await();
        Collections.sort(objects);
        for (int i = 0; i < count; i++) {
            if (i != objects.get(i)) {
                throw new RuntimeException("there is some thing wrong");
            }
        }
        System.out.println(" perfect ");
    }

    public static void deadLockTest() throws InterruptedException {
        new Thread(() -> {
            while (true) {
                synchronized (lock_a) {
                    synchronized (lock_b) {
                        System.out.println(Thread.currentThread().getName() + "successes");
                    }
                }
            }
        }, " Thread A ").start();

        new Thread(() -> {
            while (true) {
                synchronized (lock_b) {
                    synchronized (lock_a) {
                        System.out.println(Thread.currentThread().getName() + "successes");
                    }
                }
            }
        }, " Thread B ").start();
    }

    public static void weightRoundBasicLoadBalance() throws InterruptedException {
        Pair<String, Integer> of4 = new Pair<>("444.168.0.1", 4);
        Pair<String, Integer> of1 = new Pair<>("111.168.0.1", 1);
        Pair<String, Integer> of2 = new Pair<>("222.168.0.1", 2);
        Pair<String, Integer> of3 = new Pair<>("333.168.0.1", 3);
        Pair<String, Integer>[] configs = new Pair[]{of1, of2, of3, of4};
        LoadBalance_Weight_Round_Basic loadBalanceWeightRound = new LoadBalance_Weight_Round_Basic(configs);

        List<String> ips = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch signals = new CountDownLatch(2);

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                ips.add(loadBalanceWeightRound.direct());
            }
            signals.countDown();

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                ips.add(loadBalanceWeightRound.direct());
            }
            signals.countDown();

        }).start();
        signals.await();

        Map<String, Long> collect = ips.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(collect);
    }

    public static void weightRoundSleekLoadBalance() throws InterruptedException {
        Pair<String, Integer> of4 = new Pair<>("555.168.0.1", 5);
        Pair<String, Integer> of1 = new Pair<>("111.168.0.1", 2);
        Pair<String, Integer> of2 = new Pair<>("222.168.0.1", 3);
//        Pair<String, Integer> of3 = new Pair<>("333.168.0.1", 3);
        Pair<String, Integer>[] configs = new Pair[]{of1, of2, of4};
        LoadBalance_Weight_Round_Sleek loadBalanceWeightRound = new LoadBalance_Weight_Round_Sleek(configs);

        List<String> ips = Collections.synchronizedList(new ArrayList<>());

        CountDownLatch signals = new CountDownLatch(2);
        new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                ips.add(loadBalanceWeightRound.direct());
            }
            signals.countDown();
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                ips.add(loadBalanceWeightRound.direct());
            }
            signals.countDown();
        }).start();
        signals.await();
        Map<String, Long> collect = ips.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(collect);
    }


}
