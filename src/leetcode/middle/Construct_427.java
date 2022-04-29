package leetcode.middle;

public class Construct_427 {
    public Node construct(int[][] grid) {
        int l = grid.length;
        Node node = doBuildNode(grid, 0, 0, l - 1, l - 1);
        return node;
    }

    private Node doBuildNode(int[][] grid, int row1, int col1, int row2, int col2) {
        int pre = grid[row1][col1];
        boolean isSame = true;
        out:
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                if ((pre ^ grid[i][j]) == 1) {
                    isSame = false;
                    break out;
                }
            }
        }
        if (!isSame) {
            int step = (row2 - row1 + 1) / 2 - 1;
            Node topLeft = doBuildNode(grid, row1, col1, row1 + step, col1 + step);
            Node topRight = doBuildNode(grid, row1, col1 + step + 1, row1 + step, col2);
            Node bottomLeft = doBuildNode(grid, row1 + step + 1, col1, row2, col1 + step);
            Node bottomRight = doBuildNode(grid, row1 + step + 1, col1 + step + 1, row2, col2);
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        } else {
            return new Node(pre == 1, true);
        }
    }


    // Definition for a QuadTree node.
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    ;

}
