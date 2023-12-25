package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class NumOfBurgers_1276 {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        if (tomatoSlices % 2 == 1 || cheeseSlices > tomatoSlices) {
            return res;
        }
        for (int bigCnt = 0; bigCnt <= cheeseSlices; bigCnt++) {
            int smallCnt = cheeseSlices - bigCnt;
            if (smallCnt * 2 + bigCnt * 4 == tomatoSlices) {
                res.add(bigCnt);
                res.add(smallCnt);
                return res;
            }
        }
        return res;
    }
    //4a+2b=m
    //a+b=n

    //a=(m-2n)/2
    //b=n-(m-2n)/2=(4n-m)/2

    public List<Integer> numOfBurgers_(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        if (tomatoSlices % 2 != 0 || tomatoSlices < 2 * cheeseSlices || 4 * cheeseSlices < tomatoSlices) {
            return res;
        }
        res.add(tomatoSlices / 2 - cheeseSlices);
        res.add(2 * cheeseSlices - tomatoSlices / 2);
        return res;
    }

}
