package leetcode.middle;

public class FindBall_1706 {
    public int[] findBall(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }
        int[] pre = new int[grid[0].length];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = i;
        }
        return doFindBall(grid, 0, pre);
    }

    private int[] doFindBall(int[][] grid, int idx, int[] pre) {
        if (grid.length - 1 == idx) {
            return pre;
        }
        int[] cur = grid[idx];
        for (int i = 0; i < pre.length; i++) {
            int position = pre[i];
            if (position == -1) {
                continue;
            }
            if (cur[position] == 1 && position < pre.length - 1 && cur[position + 1] == 1) {
                pre[i] = position + 1;
            } else if (cur[position] == -1 && position > 0 && cur[position - 1] == -1) {
                pre[i] = position - 1;
            } else {
                pre[i] = -1;
            }
        }
        return doFindBall(grid, idx + 1, pre);
    }
}
