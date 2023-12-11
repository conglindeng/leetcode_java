package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumEffortPath_1631_UnionFind {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = i * n + j;
                if (i > 0) {
                    edges.add(new int[]{k - n, k, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{k - 1, k, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        edges.sort(Comparator.comparingInt(i -> i[2]));
        UnionFind uf = new UnionFind(m * n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
            if (uf.connected(0, m * n - 1)) {
                return edge[2];
            }
        }
        return 0;
    }


    private static class UnionFind {

        int n;
        int[] parent;
        int[] size;
        int setCount;

        public UnionFind(int n) {
            this.n = n;
            this.setCount = n;
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            } else {
                parent[x] = find(parent[x]);
                return parent[x];
            }
        }

        public boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return false;
            }
            if (size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            size[x] += size[y];
            setCount--;
            return true;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }


    }


}
