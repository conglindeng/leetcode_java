package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement_397 {
    private Map<Integer, Integer> info = new HashMap<>();

    public int integerReplacement(int n) {
        if (info.get(n) != null) {
            return info.get(n);
        }
        if (n == 1) {
            info.put(1, 0);
            return 0;
        }
        if (n % 2 == 0) {
            int i = 1 + integerReplacement(n / 2);
            info.put(n, i);
            return i;
        }
        int i = 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
        info.put(n, i);
        return i;
    }
}
