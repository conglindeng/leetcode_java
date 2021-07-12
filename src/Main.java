
import algorithm.*;
import algorithm.slidingwindow.MaxSum;
import array.MergeTwoArray;
import leetcode.easy.*;
import leetcode.middle.*;
import net.sf.cglib.core.CollectionUtils;
import newcode.MergeTwoSortArray;
import org.apache.commons.lang.StringUtils;
import sort.LargeQuantitiesSort;
import struct.TreeNode;
import util.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicStampedReference;
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

        new NC109_Solve().solve(new char[][]{{'1','0','1'},{'0','0','1'},{'1','0','0'}});

        Map<String,String> param=new HashMap<>();
        param.put("name","dsfdsf");
        param.put("md","yyyyy");
        StringUtils.replace(" select {{md}} * from {{  name ",param);
    }
}
