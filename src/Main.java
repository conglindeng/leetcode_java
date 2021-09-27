
import algorithm.ArraySort;
import leetcode.easy.*;
import newcode.*;
import util.Heap;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {
    static long[][] arr;

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

        //System.out.println(strings);


        // todo: begin
        //List<String> strings = new NC20_RestoreIpAddresses().restoreIpAddresses("23001000");
        //new NC10_Solve().solve("733064366","459309139");
        //new NC126_MinMoney().minMoney(new int{}{2, 3, 5}, 20);
        //new NC110_Solve().solve(6, 5, new int{}{1, 2, 3, 4, 5, 6});
        // todo: end

        ArraySort.heapSort(new int[]{3,4});


        System.out.println();

    }





}
