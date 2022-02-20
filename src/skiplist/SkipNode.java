package skiplist;

class SkipNode {
    int key;
    int val;
    SkipNode right, down;

    public SkipNode(int key, int val) {
        this.val = val;
        this.key = key;
        right = null;
        down = null;
    }
}