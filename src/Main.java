import essay.sort.ShellSort;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import leetcode.easy.CountPairs_2824;
import leetcode.middle.FrontMiddleBackQueue_1670_Deque;


public class Main {

    private static final Object lock = new Object();

    private final static ThreadPoolExecutor executor = new ThreadPoolExecutor(
        2, 20, 2, TimeUnit.SECONDS,
        new LinkedBlockingDeque<>(3), r -> new Thread(r, "myPool")
    );

    public static void main(String[] args) throws Exception {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-", ""));

        CountPairs_2824 countPairs2824 = new CountPairs_2824();
        countPairs2824.countPairs(Arrays.asList(-1, 1, 2, 3, 1), 2);

        int[] ints = {3};
        new ShellSort().shellSort(ints);

        FrontMiddleBackQueue_1670_Deque q = new FrontMiddleBackQueue_1670_Deque();
        q.pushMiddle(3);   // [1]
        q.pushFront(6);    // [1, 2]
        q.pushMiddle(6);  // [1, 3, 2]
        q.pushMiddle(3);  // [1, 4, 3, 2]
        q.popMiddle();     // 返回 1 -> [4, 3, 2]
        q.popMiddle();    // 返回 3 -> [4, 2]
        q.popMiddle();    // 返回 4 -> [2]
        q.popBack();      // 返回 2 -> []
        q.popFront();     // 返回 -1 -> [] （队列为空）





        System.out.println(ints);
        ServiceLoader<InputStream> inputStreams = ServiceLoader.load(InputStream.class,
            Thread.currentThread().getContextClassLoader());
        Iterator<InputStream> iterator = inputStreams.iterator();
        while (iterator.hasNext()) {
            InputStream next = iterator.next();
            next.read();
        }

        //region todo
//        Skiplist_120 skiplist_120 = new Skiplist_120();
//        skiplist_120.add(1);
//        skiplist_120.add(3);
//        skiplist_120.add(4);
//        skiplist_120.add(6);
//        skiplist_120.add(5);
//        skiplist_120.add(9);
//        skiplist_120.add(2);
//
//        skiplist_120.erase(4);
//
        //endregion
    }

    private static void getDateAndPrint() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DAY_OF_YEAR, -1);
        Date time = instance.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(time));
    }
}

/*todo list:
1.https://leetcode.cn/problems/count-different-palindromic-subsequences/
3.https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
4.https://leetcode.cn/problems/minimum-number-of-refueling-stops/
5.https://leetcode.cn/problems/parse-lisp-expression/solution/lisp-yu-fa-jie-xi-by-leetcode-solution-zycb/
*/






