
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

        String str="'2c9040af4fd9bf36014fd9dca4970095','2c9040af4fd9bf36014fd9dca4970095','2c9040af4fd9bf36014fd9dca4970095'," +
                "'2c9040af4fd9bf36014fd9dca4970095','2c9040af4fd9bf36014fd9dca4970095','2c9040af4fd9bf36014fd9dca4970095'," +
                "'2c9040af4fd9bf36014fd9dca4970095','2c9040af4fd9bf36014fd9dca4970095','2c9040af4fd9bf36014fd9dca4970095'," +
                "'2c9040af4fd9bf36014fd9dca4970095','2c9040af4fd9bf36014fd9dca4970095','2c9040af4fd9bf36014fd9dca4970095'," +
                "'2c9040af4fd9bf36014fd9dca4970095','2c9040af4fd9bf36014fd9dca4970095','2c9040af4fd9bf36014fd9dca4970095'," +
                "'2c9040af4fd9bf36014fd9dca4970095','2c9040af4fd9bf36014fd9dca4970095','2c9040af4fd9bf36014fd9dca4970095'," +
                "'2c9040af4fd9bf36014fd9dca4970095','2c9040af4fd9bf36014fd9dca4970095','2c9040af4fcec089014fcfdafb28035d'," +
                "'2c99905f7456e81401746b6e369c0076','2c9040af4fcec089014fcfdafb28035d','2c99905f7456e81401746b6e369c0076'," +
                "'2c9040af4fcec089014fcfdafb28035d','2c99905f7456e81401746b6e369c0076','2c9040af4fcec089014fcfdafb28035d'," +
                "'2c99905f7456e81401746b6e369c0076','2c9040af4fcec089014fcfdafb28035d','2c99905f7456e81401746b6e369c0076'," +
                "'2c9040af4fcec089014fcfdafb28035d','2c99905f7456e81401746b6e369c0076','2c9040af4fcec089014fcfdafb28035d'," +
                "'2c99905f7456e81401746b6e369c0076','2c9040af4fcec089014fcfdafb28035d','2c99905f7456e81401746b6e369c0076'," +
                "'2c9040af4fcec089014fcfdafb28035d','2c99905f7456e81401746b6e369c0076','2c9040af4fcec089014fcfdafb28035d'," +
                "'2c99905f7456e81401746b6e369c0076','2c9040af4fcec089014fcfdafb28035d','2c99905f7456e81401746b6e369c0076'," +
                "'2c9040af4fcec089014fcfdafb28035d','2c99905f7456e81401746b6e369c0076','2c9040af4fcec089014fcfdafb28035d'," +
                "'2c99905f7456e81401746b6e369c0076','2c9040af4fcec089014fcfdafb28035d','2c99905f7456e81401746b6e369c0076'," +
                "'2c9040af4fcec089014fcfdafb28035d','2c99905f7456e81401746b6e369c0076','2c9040af4fcec089014fcfdafb28035d'," +
                "'2c99905f7456e81401746b6e369c0076','2c9040af4fcec089014fcfdafb28035d','2c99905f7456e81401746b6e369c0076'," +
                "'2c9040af4fcec089014fcfdafb28035d','2c99905f7456e81401746b6e369c0076','2c9040af4fcec089014fcfdafb28035d'," +
                "'2c99905f7456e81401746b6e369c0076','2c9040af4fcec089014fcfdafb28035d','2c99905f7456e81401746b6e369c0076'," +
                "'0d8183fa79070317017907623e9608bc','0d8183fa79070317017907623e9608bc','0d8183fa79070317017907623e9608bc'," +
                "'0d8183fa79070317017907623e9608bc'";
        String[] split = StringUtils.split(str, ",");
        Set<String> set=new TreeSet<>();
        for(String s: split){
            set.add(s.trim());
        }
        System.out.println(set);
    }
}
