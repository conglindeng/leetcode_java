
import sort.ArraySort;

import java.util.*;

public class Main {
    static long[][] arr;

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));


        ArraySort.buddleSort(new int[]{-1, 1, 2, 3, 5, 4});


        List<String> list = new ArrayList<>();
        list.iterator();
        list.add("1");
        list.add("2");
        for (String s : list) {
            if ("1".equals(s)) {
                list.remove(s);
            }
        }
        System.out.println();
    }
}
