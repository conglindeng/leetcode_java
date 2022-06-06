package leetcode.middle;

import java.util.Arrays;

/**
 * @ClassName Makesquare_473
 * @Description TODO
 * @Author conglindeng
 * @Date 2022/6/1 09:48
 * @Version 1.0
 */
public class Makesquare_473 {

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[j];
            matchsticks[j] = matchsticks[i];
            matchsticks[i] = temp;
        }
        int[] edges = new int[4];
        return bfs(0, sum / 4, edges, matchsticks);
    }

    private boolean bfs(int index, int target, int[] edges, int[] matchsticks) {
        if (index == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= target && bfs(index + 1, target, edges, matchsticks)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }
}
