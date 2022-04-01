package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers_728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (judge(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean judge(int i) {
        if (i < 10 && i > 0) {
            return true;
        }
        if (i % 10 == 0) {
            return false;
        }
        int m = i;
        while (m != 0) {
            int k = m % 10;
            if (k == 0) {
                return false;
            }
            if (i % k != 0) {
                return false;
            }
            m = m / 10;
        }
        return true;
    }

}
