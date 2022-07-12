import algorithm.KMP;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import leetcode.difficult.MyCalendarThree_732;
import leetcode.difficult.RangeModule_715;


public class Main {

    private final static ThreadPoolExecutor executor = new ThreadPoolExecutor(
        2, 20, 2, TimeUnit.SECONDS,
        new LinkedBlockingDeque<>(3), r -> new Thread(r, "myPool")
    );

    public static void main(String[] args) throws Exception {

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-", ""));

        MyCalendarThree_732 myCalendarThree = new MyCalendarThree_732();
        int book = myCalendarThree.book(10, 20);// 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        book = myCalendarThree.book(0, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        book = myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
        book = myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
        book = myCalendarThree.book(5, 10); // 返回 3
        book = myCalendarThree.book(25, 55); // 返回 3

        RangeModule_715 rangeModule_715 = new RangeModule_715();

        // new AlienOrder_Offer_114().alienOrder(new String[]{"wrt", "wrtkj"});

        KMP ababc = new KMP("ababc");
        int abab = ababc.search("abababc");

        oddCells(2, 2, new int[][]{{1, 1}, {0, 1}});

        System.out.println();

    }


    public static int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];
        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }
        int res = 0;
        for (int i = 0; i < m + n; i++) {
            if ((row[i / m] + col[(i % m)]) % 2 != 0) {
                res++;
            }
        }
        return res;
    }

}