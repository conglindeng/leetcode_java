package redblacktree;

public class RedBlackNode {
    RedBlackNode left;
    RedBlackNode right;
    int key;
    int val;
    boolean isRed;

    public RedBlackNode(int key, int val) {
        this(key, val, null, null, true);
    }

    public RedBlackNode(int key, int val, RedBlackNode left, RedBlackNode right, boolean isRed) {
        this.val = val;
        this.key = key;
        this.left = left;
        this.right = right;
        this.isRed = isRed;
    }

}
