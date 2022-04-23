package leetcode.difficult;

import java.util.HashMap;
import java.util.Map;

public class OuterTrees_587 {
    public int[][] outerTrees(int[][] trees) {
        //先找到上下左右的顶点，再遍历点判断是否在围成区域的外边，若是的话，则需要取离最远的那个点
        int[] left = new int[]{Integer.MAX_VALUE, 0};
        int[] right = new int[]{Integer.MIN_VALUE, 0};
        int[] top = new int[]{0, Integer.MIN_VALUE};
        int[] bottom = new int[]{0, Integer.MAX_VALUE};
        for (int[] tree : trees) {
            if (tree[0] < left[0]) {
                left[0] = tree[0];
                left[1] = tree[1];
            }
            if (tree[0] > right[0]) {
                right[0] = tree[0];
                right[1] = tree[1];
            }
            if (tree[1] > top[1]) {
                top[0] = tree[0];
                top[1] = tree[1];
            }
            if (tree[1] < bottom[1]) {
                bottom[0] = tree[0];
                bottom[1] = tree[1];
            }
        }
        Map<Integer, int[]> m = new HashMap<>();
        for (int[] tree : trees) {
            if (leftOfLine(left, top, tree)) {
                update(m, 0, tree, left, top);
            }
            if (rightOfLine(left, bottom, tree)) {
                update(m, 1, tree, left, bottom);
            }
            if (rightOfLine(right, top, tree)) {
                update(m, 2, tree, right, top);
            }
            if (leftOfLine(right, bottom, tree)) {
                update(m, 3, tree, right, bottom);
            }
        }

        //可以计算出所有的边，但还需要处理在线上的点

/*        List<int[]> line = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int[] ints = m.get(i);
            if (ints != null) {
                if (i == 0) {
                    line.add(new int[]{});
                }
            }
        }
        for (int[] tree : trees) {

        }*/
        return null;
    }

    private void update(Map<Integer, int[]> m, int i, int[] tree, int[] p1, int[] p2) {
        int[] ints = m.get(i);
        if (ints == null) {
            m.put(i, tree);
        } else {
            if (getInstance(p1, p2, tree) > getInstance(p1, p2, ints)) {
                m.put(i, tree);
            }
        }
    }

    private int getInstance(int[] p1, int[] p2, int[] tree) {
        return (int) (Math.abs(p2[1] - p1[1] * tree[0] + (p1[0] - p2[0]) * tree[1] + (p1[1] - p2[1]) * p1[0] + (p2[0] - p1[0]) * p1[1]) / Math.sqrt((p2[2] - p1[1]) * (p2[2] - p1[1]) + (p1[0] - p2[0]) * (p1[0] - p2[0])));

    }

    private boolean leftOfLine(int[] p1, int[] p2, int[] p) {
        double tmpx = (p1[1] - p2[1]) * p[0] + (p2[0] - p1[0]) * p[1] + p1[0] * p2[1] - p2[0] * p1[1];
        return tmpx > 0;
    }

    private boolean rightOfLine(int[] p1, int[] p2, int[] p) {
        double tmpx = (p1[1] - p2[1]) * p[0] + (p2[0] - p1[0]) * p[1] + p1[0] * p2[1] - p2[0] * p1[1];
        return tmpx < 0;
    }
}
