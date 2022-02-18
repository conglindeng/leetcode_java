package leetcode.middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Connect_117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //层次遍历
        Deque<Node> work = new LinkedList<>();
        work.push(root);
        while (!work.isEmpty()) {
            List<Node> next = new ArrayList<>();
            while (!work.isEmpty()) {
                Node poll = work.poll();
                if (!work.isEmpty()) {
                    poll.next = work.peek();
                }
                if (poll.left != null)
                    next.add(poll.left);
                if (poll.right != null)
                    next.add(poll.right);
            }
            work.addAll(next);
        }
        return root;
    }


    public Node connect_Optimize(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (true) {
            //当第一个节点寻找为空时
            Node first = findNext(cur);
            if (first == null) {
                break;
            }
            //假的前一节点
            Node pre = new Node();
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = cur.left;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = first;
        }
        return root;
    }

    private Node findNext(Node cur) {
        while (cur != null) {
            if (cur.left != null) {
                return cur.left;
            }
            if (cur.right != null) {
                return cur.right;
            }
            cur = cur.next;
        }
        return null;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
