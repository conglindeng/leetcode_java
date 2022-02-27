package leetcode.middle;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList_138 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> cache = new HashMap<>();
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            if (cache.get(cur) == null) {
                Node n = new Node(cur.val);
                cache.put(cur, n);
            }
            if (pre != null) {
                pre.next = cache.get(cur);
            }
            pre = cache.get(cur);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            cache.get(cur).random = cache.get(cur.random);
            cur = cur.next;
        }
        return cache.get(head);
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
