package leetcode.difficult;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne_432 {
    Node root;
    Map<String, Node> count;

    public AllOne_432() {
        root = new Node();
        root.prev = root;
        root.next = root;
        count = new HashMap<>();
    }

    public void inc(String key) {
        if (count.containsKey(key)) {
            //包含的话需要将之count加1，且向后挪动
            Node cur = count.get(key);
            cur.strs.remove(key);
            if (cur.count + 1 < cur.next.count || cur.next == root) {
                //需要insert一个
                count.put(key, cur.insert(new Node(key, cur.count + 1)));
                if (cur.strs.size() == 0) {
                    cur.remove();
                }
            } else {
                cur.next.strs.add(key);
                count.put(key, cur.next);
            }
            if (cur.strs.size() == 0) {
                cur.remove();
            }
        } else {
            //不包含则需要判定root.next 的count与1的大小关系
            //如果大于1的话，则需要在root后新增一个node
            if (root.next.count > 1 || root.next == root) {
                count.put(key, root.insert(new Node(key, 1)));
            } else {
                root.next.strs.add(key);
                count.put(key, root.next);
            }
        }
    }

    public void dec(String key) {
        if (!count.containsKey(key)) {
            return;
        }
        Node node = count.get(key);
        node.strs.remove(key);
        if (node.strs.size() == 0) {
            node.remove();
        }
        if (node.count == 1) {
            count.remove(key);
            return;
        }
        Node prev = node.prev;
        int curCount = node.count - 1;
        if (prev == root || prev.count < curCount) {
            count.put(key, prev.insert(new Node(key, curCount)));
        } else if (prev.count == curCount) {
            prev.strs.add(key);
            count.put(key, prev);
        }
    }

    public String getMaxKey() {
        return root.prev == root ? "" : root.prev.strs.iterator().next();
    }

    public String getMinKey() {
        return root.next == root ? "" : root.next.strs.iterator().next();
    }


    class Node {
        //指向小于当前count的Node
        Node prev;
        //指向大于当前count的Node
        Node next;
        //当前的count
        int count;
        //当前count数量所有的字符串
        Set<String> strs;

        public Node() {
            this("", 0);
        }

        public Node(String key, int count) {
            this.count = count;
            strs = new HashSet<>();
            strs.add(key);
        }

        /**
         * 插入一个新的节点，插入方向为next
         * 如果是要在cur的前面插入，则将cur往prev方向走一次，转化为向后插入的情况，cur=cur.prev
         *
         * @return 返回插入的节点
         */
        private Node insert(Node insert) {
            insert.next = this.next;
            insert.prev = this;
            this.next.prev = insert;
            this.next = insert;
            return insert;
        }

        private Node remove() {
            this.prev.next = this.next;
            this.next.prev = this.prev;
            return this;
        }
    }

}
