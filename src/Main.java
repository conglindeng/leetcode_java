
import algorithm.ArraySort;
import leetcode.easy.*;
import leetcode.middle.*;
import newcode.*;
import sun.nio.ch.ThreadPool;
import util.Heap;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {

    private static final ExecutorService executorService = Executors.newCachedThreadPool(Executors.defaultThreadFactory());

    public static void main(String[] args) throws Exception {

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-", ""));
        ReadBinaryWatch_401.readBinaryWatch(1);
/*        LRUCache_146_Optimize lRUCache = new LRUCache_146_Optimize(1);
        lRUCache.put(1, 1);
        lRUCache.get(1);
        lRUCache.put(2, 2);
        lRUCache.get(1);
        lRUCache.get(2);*/

        //String[] strings = new NC124_TrieU().trieU(new String[][]{{"1", "qwer"}, {"1", "qwe"}, {"3", "qwer"}, {"4", "q"}, {"2", "qwer"}, {"3", "qwer"}, {"4", "q"}});

        // todo: begin
        //List<String> strings = new NC20_RestoreIpAddresses().restoreIpAddresses("23001000");
        //new NC10_Solve().solve("733064366","459309139");
        //new NC126_MinMoney().minMoney(new int{}{2, 3, 5}, 20);
        //new NC110_Solve().solve(6, 5, new int{}{1, 2, 3, 4, 5, 6});
        // todo: end


        //new IsPossibleDivide_1296().findIndex(8,new int[]{1,2,3,3,5,6,7,7},null);
        new FindRelativeRanks_506().findRelativeRanks(new int[]{5, 4, 3, 2, 1});


        System.out.println();
    }




}
