package newcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NC73_MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        Arrays.sort(array);
        return array[array.length/2];
       /* Map<Integer, Integer> count = new HashMap<>();
        int length = array.length;
        for (int i : array) {
            count.put(i, count.getOrDefault(i, 0) + 1);
            if (count.get(i) > length / 2) {
                return i;
            }
        }
        return -1;*/
    }
}
