import essay.LoadBalance_Weight_Round_Basic;
import essay.LoadBalance_Weight_Round_Sleek;
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
        weightRoundSleekLoadBalance();
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
