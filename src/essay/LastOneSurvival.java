package essay;

import java.util.HashSet;
import java.util.Set;

/**
 * 编号为 1-n 的循环报 1-3，报道 3 的出列，求最后一人的编号
 */
public class LastOneSurvival {

    //this solution will time out when n is too big
    public static int lastOneSurvival(int n) {
        Set<Integer> removed = new HashSet<>();
        int i = 0;
        int step = 0;
        while (removed.size() < n - 1) {
            if (!removed.contains(i)) {
                if (step == 2) {
                    removed.add(i);
                }
                step++;
                step = step % 3;
            }
            i++;
            i = i % n;
        }
        for (int j = 0; j < n; j++) {
            if (!removed.contains(j)) {
                return j + 1;
            }
        }
        return -1;
    }


    public static int lastOneSurvival_with_recursion(int n) {
        return f(n, 3) + 1;
    }

    private static int f(int n, int target) {
        if (n == 1) {
            return 0;
        }
        return (f(n - 1, target) + target) % n;
    }

    /**
     *
     *  int i = LastOneSurvival.lastOneSurvival(1000);
     *  int j = LastOneSurvival.lastOneSurvival_with_recursion(1000);
     *  System.out.println(i);
     *  System.out.println(j);
     *
     */
}
