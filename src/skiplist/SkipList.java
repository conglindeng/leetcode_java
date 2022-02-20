package skiplist;

public class SkipList {

    SkipNode head;

    public SkipList() {
        this.head = new SkipNode(-1, -1);
    }

    public SkipNode search(int key) {
        SkipNode temp = head;
        while (temp != null) {
            if (temp.key == key) {
                return temp;
            } else if (temp.right == null) {
                temp = temp.down;
            } else if (temp.right.key > key) {
                temp = temp.down;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }
}
