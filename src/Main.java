import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import leetcode.difficult.AlienOrder_Offer_BFS_114;
import leetcode.difficult.RangeModule_715;


public class Main {

    private final static ThreadPoolExecutor executor = new ThreadPoolExecutor(
        2, 20, 2, TimeUnit.SECONDS,
        new LinkedBlockingDeque<>(3), r -> new Thread(r, "myPool")
    );

    public static void main(String[] args) throws Exception {

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-", ""));

        RangeModule_715 rangeModule_715 = new RangeModule_715();

        new AlienOrder_Offer_BFS_114().alienOrder(new String[]{"ac", "ab", "zc", "zb"});

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

        System.out.println();
    }
}

//todo list:
//1.https://leetcode.cn/problems/count-different-palindromic-subsequences/
//3.https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
//4.https://leetcode.cn/problems/minimum-number-of-refueling-stops/
//5.https://leetcode.cn/problems/parse-lisp-expression/solution/lisp-yu-fa-jie-xi-by-leetcode-solution-zycb/


