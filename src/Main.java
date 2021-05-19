
import algorithm.*;
import algorithm.slidingwindow.MaxSum;
import leetcode.easy.XorOperation_1486;
import leetcode.middle.*;
import net.sf.cglib.core.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import sort.ArraySort;
import struct.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.stream.Collectors;

public class Main {
    static long[][] arr;

    public static void main(String[] args) {
        new IntToRoman_12().intToRoman(1994);


        LinkedHashMap<String,String> cache=new LinkedHashMap<String,String>(3){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size()>=2;
            }
        };

        cache.put("1","1");
        cache.put("2","2");
        cache.put("3","3");
        cache.put("4","4");
    }
}
