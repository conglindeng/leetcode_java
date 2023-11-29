package leetcode.middle;

public class SmallestInfiniteSet_2336 {

    Node head;

    public SmallestInfiniteSet_2336() {
        head = new Node(1, 2);
    }

    public int popSmallest() {
        Node cur = head;
        int res = cur.val;
        if (cur.type == 2) {
            cur.val++;
        } else {
            head = cur.next;
            cur.next = null;
        }
        return res;
    }

    public void addBack(int num) {
        Node pre = null;
        Node cur = head;
        while (cur.val < num) {
            if (cur.type == 2) {
                return;
            }
            pre = cur;
            cur = cur.next;
        }
        if (cur.val > num) {
            return;
        }
        Node node = new Node(num, 1);
        if (pre == null) {
            node.next = head;
            head = node;
        } else {
            node.next = cur;
            pre.next = node;
        }
    }

    private static class Node {

        int val;
        int type;//1-single =val ,2-range  >= val

        Node next;

        public Node(int val, int type) {
            this.val = val;
            this.type = type;
        }
    }

}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such: SmallestInfiniteSet obj = new
 * SmallestInfiniteSet(); int param_1 = obj.popSmallest(); obj.addBack(num);
 */