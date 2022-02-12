package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractions_1447 {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (j == 1 || !hasCommonFactor(i, j)) {
                    res.add(j + "/" + i);
                }
            }
        }
        return res;
    }


    private boolean hasCommonFactor(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        for (; ; ) {
            int i = m % n;
            if (i == 0) {
                break;
            }
            m = n;
            n = i;
        }
        return n != 1;
    }

}
