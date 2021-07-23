
import algorithm.*;
import algorithm.slidingwindow.MaxSum;
import annotation.DclTest;
import array.MergeTwoArray;
import leetcode.easy.*;
import leetcode.middle.*;
import net.sf.cglib.core.CollectionUtils;
import newcode.*;
import sort.LargeQuantitiesSort;
import struct.TreeNode;
import util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicStampedReference;


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
        int[] array = {1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247, 986578, 798663};
        ArraySort.fastSort(array);
        for (int i : array) {
            System.out.print(i+", ");
        }
        System.out.println(array);
        //int kth = new NC88_FindKth().findKth(array, 49, 24);
        //new LCS().longestCommonSubStr("abcmgj","abcgdmgjs");
        System.out.println();

    }
}
