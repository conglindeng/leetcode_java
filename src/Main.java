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
import leetcode.easy.IsPalindrome_125;
import leetcode.middle.CarPooling_1094;
import leetcode.middle.CountCompleteSubstrings_100145;
import leetcode.middle.MaxScore_1423;


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

        new IsPalindrome_125().isPalindrome("A man, a plan, a canal: Panama");

        new CarPooling_1094().carPooling(new int[][]{

            {10, 5, 7}, {10, 3, 4}, {7, 1, 8}, {6, 3, 4}
        }, 23);

        new CountCompleteSubstrings_100145().countCompleteSubstrings("gvgvvgv",2);

        new MaxScore_1423().maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3);

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






