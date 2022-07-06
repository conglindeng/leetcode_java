import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import leetcode.difficult.MyCalendarThree_732;
import leetcode.difficult.RangeModule_715;
import leetcode.middle.NextGreaterElement_556;


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

        new NextGreaterElement_556().nextGreaterElement(12443322);

        System.out.println();

    }


}