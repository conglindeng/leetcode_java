package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class EatenApples_1705 {
    public int eatenApples(int[] apples, int[] days) {
        //使用map来维护某一天剩余的可吃苹果
        //对于天数n来说，最优的抉择是向后取离当前最近的那天的苹果来吃,吃了过后，当前n对应的苹果就过期了，应该remove掉。
        Map<Integer, Integer> work = new HashMap<>();
        int res = 0;
        int i = 1;
        for (; i <= apples.length; i++) {
            int apple = apples[i-1];
            int day = days[i-1];
            if (apple > 0) {
                work.put(i + day-1, work.getOrDefault(i + day-1, 0) + apple);
            }
            res += findOneApple2Eat(i, work);
            work.remove(i);
        }
        while (true) {
            int oneApple2Eat = findOneApple2Eat(i, work);
            if (oneApple2Eat == 0) {
                break;
            }
            work.remove(i);
            i++;
            res += 1;
        }
        return res;
    }

    private int findOneApple2Eat(int i, Map<Integer, Integer> work) {
        final int[] minDay = {Integer.MAX_VALUE};
        work.forEach((day, apple) -> {
            if (apple > 0) {
                minDay[0] = Math.min(day, minDay[0]);
            }
        });
        int day = minDay[0];
        if (day == Integer.MAX_VALUE) {
            return 0;
        }
        work.put(day, work.get(day) - 1);
        return 1;
    }
}
