import essay.sort.MergeSort;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Main {

    private static final Object lock = new Object();

    private final static ThreadPoolExecutor executor = new ThreadPoolExecutor(
        2, 20, 2, TimeUnit.SECONDS,
        new LinkedBlockingDeque<>(3), r -> new Thread(r, "myPool")
    );

    public static void main(String[] args) throws Exception {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-", ""));
//7, 1, 4, 4
        //12, 4, 1, 13, 17, 18
        int[] ints = {13, 19, 11, 12};
        int[] ints1 = new MergeSort().mergeSort(ints);
        System.out.println(Arrays.toString(ints));
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
}

/*todo list:
1.https://leetcode.cn/problems/count-different-palindromic-subsequences/
3.https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
4.https://leetcode.cn/problems/minimum-number-of-refueling-stops/
5.https://leetcode.cn/problems/parse-lisp-expression/solution/lisp-yu-fa-jie-xi-by-leetcode-solution-zycb/
*/






