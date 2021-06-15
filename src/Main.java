
import algorithm.*;
import algorithm.slidingwindow.MaxSum;
import array.MergeTwoArray;
import leetcode.easy.IsPowerOfFour_342;
import leetcode.easy.LastStoneWeight_1046;
import leetcode.easy.XorOperation_1486;
import leetcode.middle.*;
import net.sf.cglib.core.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import sort.ArraySort;
import sort.LargeQuantitiesSort;
import struct.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.stream.Collectors;

public class Main {
    static long[][] arr;

    public static void main(String[] args) throws Exception {

/*        LRUCache_146_Optimize lRUCache = new LRUCache_146_Optimize(1);
        lRUCache.put(1, 1);
        lRUCache.get(1);
        lRUCache.put(2, 2);
        lRUCache.get(1);
        lRUCache.get(2);*/
        System.out.println(new NumSquares_279().numSquares(6));
    }


    public static int[] selectSort(int[] nums){
        int length = nums.length;
        for (int i = 0; i < length-2; i++) {
            for(int j=i+1;j<length;j++){

            }
        }
        return nums;
    }
}
