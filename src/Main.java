import competition.day23_12_31.maximumLength_100184;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;
import leetcode.middle.MinimumPerimeter_1954;


public class Main {

    private static final Object lock = new Object();

    private final static ThreadPoolExecutor executor = new ThreadPoolExecutor(
        2,
        20,
        2,
        TimeUnit.SECONDS,
        new LinkedBlockingDeque<>(3),
        r -> new Thread(r, "myPool"),
        new CallerRunsPolicy()
    );

    public static void main(String[] args) throws Exception {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-", ""));

        ServiceLoader<InputStream> inputStreams = ServiceLoader.load(InputStream.class,
            Thread.currentThread().getContextClassLoader());
        Iterator<InputStream> iterator = inputStreams.iterator();
        while (iterator.hasNext()) {
            InputStream next = iterator.next();
            next.read();
        }

        System.out.println(Integer.MAX_VALUE);

        new MinimumPerimeter_1954().minimumPerimeter(1);

        new maximumLength_100184().maximumLength("abcaba");

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

    public int dayOfYear(String date) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        String[] strs = date.split("-");
        int year = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int day = Integer.parseInt(strs[2]);
        int res = 0;
        if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) && month > 2) {
            res++;
        }
        for (int i = 1; i < month; i++) {
            res += monthDays[i - 1];
        }
        return res + day;
    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] m = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar instance = Calendar.getInstance();
        instance.set(year, month, day);
        int i = instance.get(Calendar.DAY_OF_WEEK);
        return m[i];
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






