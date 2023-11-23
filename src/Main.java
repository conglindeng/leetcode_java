import essay.sort.ShellSort;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import leetcode.middle.EntityParser_1410;
import leetcode.middle.MinPathCost_2304;


public class Main {

    private static final Object lock = new Object();

    private final static ThreadPoolExecutor executor = new ThreadPoolExecutor(
        2, 20, 2, TimeUnit.SECONDS,
        new LinkedBlockingDeque<>(3), r -> new Thread(r, "myPool")
    );

    public static void main(String[] args) throws Exception {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-", ""));
        new MinPathCost_2304().minPathCost(new int[][]{{5, 3}, {4, 0}, {2, 1}}, new int[][]{

            {9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}

        });

        List<String> list = Arrays.asList(new String[]{"string", "sdfa"});
        list.add("dsfsdf");


        new EntityParser_1410().entityParser("&&gt;");

        int[] ints = {3};
        new ShellSort().shellSort(ints);

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






