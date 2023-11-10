import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
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

        ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();
        cache.put("1", "1");

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


    static class Info {

        long order;
        long newOrder;
        String userName;

        public long getOrder() {
            return order;
        }

        public void setOrder(long order) {
            this.order = order;
        }

        public long getNewOrder() {
            return newOrder;
        }

        public void setNewOrder(long newOrder) {
            this.newOrder = newOrder;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

    public List<Info> getUpdateOrders(List<Info> infoList) {
        Map<Long, Integer> order2Index = new HashMap<>();
        for (int i = 0; i < infoList.size(); i++) {
            order2Index.put(infoList.get(i).order, i);
        }
        infoList.sort((a, b) -> {
            if (a.order == b.order) {
                return 0;
            }
            return a.order > b.order ? 1 : -1;
        });
        List<Info> needUpdate = new ArrayList<>();
        Info head = null;
        Map<Long, Integer> newOrder2Index = new HashMap<>();
        for (int i = 0; i < infoList.size(); i++) {
            Info info = infoList.get(i);
            if (order2Index.get(info.order) != i && head == null) {
                head = info;
            }
            newOrder2Index.put(info.order, i);
        }
        while (head != null) {
            long order = head.order;
            Integer oldIdx = order2Index.get(order);
            Integer newIdx = newOrder2Index.get(order);
            head.newOrder = newIdx;

        }
        return needUpdate;
    }


}

/*todo list:
1.https://leetcode.cn/problems/count-different-palindromic-subsequences/
3.https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
4.https://leetcode.cn/problems/minimum-number-of-refueling-stops/
5.https://leetcode.cn/problems/parse-lisp-expression/solution/lisp-yu-fa-jie-xi-by-leetcode-solution-zycb/
*/






