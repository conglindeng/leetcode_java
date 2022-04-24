package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class IHappy_202 {

    public boolean isHappy(int n) {
        Set<Integer> intSet = new HashSet<>();
        while (n != 0 && !intSet.contains(n)) {
            intSet.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int res = 0;
        while (n != 0) {
            int m = n % 10;
            res += m * m;
            n = n / 10;
        }
        return res;
    }

}
