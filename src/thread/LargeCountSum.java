package thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class LargeCountSum {
    ThreadPoolExecutor executor;

    /**
     * 有一千万个数，写一个程序进行高效求和
     */
    public int largeCountSum() {
        int coreSize = Runtime.getRuntime().availableProcessors() + 1;
        int[] largeCountNums = getLargeCountNums(10000000);
        executor = new ThreadPoolExecutor(coreSize, coreSize, 5, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        LongAdder sum = new LongAdder();
        int count = coreSize;
        int step = largeCountNums.length / count;
        for (int i = 0; i < count; i++) {
            executor.submit(() -> {
                //int left=
            });
        }
        return -1;
    }

    public int[] getLargeCountNums(int k) {
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
