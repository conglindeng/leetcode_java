
import algorithm.*;
import algorithm.slidingwindow.MaxSum;
import annotation.DclTest;
import array.MergeTwoArray;
import leetcode.easy.*;
import leetcode.middle.*;
import net.sf.cglib.core.CollectionUtils;
import newcode.MergeTwoSortArray;
import org.apache.commons.lang.StringUtils;
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
        //new NC18_RotateMatrix().rotateMatrix(new int [][]{{1,2,3},{4,5,6},{7,8,9}},3);

        //new NC77_ReOrderArray().reOrderArray(new int[]{1, 2, 4, 5, 7});

        new FindStrInArray().findStrInArray(new char[][]{{'a','d','n'},{'b','n','a'},{'m','d','a'}},"aanda");
    }
}
