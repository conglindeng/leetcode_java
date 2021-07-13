
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

        NC42_PermuteUnique nc42_permuteUnique = new NC42_PermuteUnique();

        dealAnnotation(nc42_permuteUnique);
    }

    private static void dealAnnotation(NC42_PermuteUnique nc42_permuteUnique) {
        Class<? extends NC42_PermuteUnique> aClass = nc42_permuteUnique.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for(Field f: fields){
            f.setAccessible(true);
            DclTest declaredAnnotations = f.getDeclaredAnnotation(DclTest.class);
            String value = declaredAnnotations.value();
            System.out.println(
            );
        }
    }

}
