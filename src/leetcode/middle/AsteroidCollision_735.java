package leetcode.middle;

import java.util.Deque;
import java.util.LinkedList;

public class AsteroidCollision_735 {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> work = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (work.isEmpty()) {
                work.addLast(asteroids[i]);
            } else {
                while (true) {
                    if (work.peekLast() > 0 && asteroids[i] < 0) {
                        if (Math.abs(work.peekLast()) == Math.abs(asteroids[i])) {
                            work.pollLast();
                            break;
                        } else if (Math.abs(work.peekLast()) > Math.abs(asteroids[i])) {
                            break;
                        } else {
                            work.pollLast();
                            if (work.isEmpty()) {
                                work.addLast(asteroids[i]);
                                break;
                            }
                        }
                    } else {
                        work.addLast(asteroids[i]);
                        break;
                    }
                }
            }
        }
        int[] res = new int[work.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = work.pollLast();
        }
        return res;
    }


}
