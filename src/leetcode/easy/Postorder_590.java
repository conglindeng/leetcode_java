package leetcode.easy;

import java.util.*;

public class Postorder_590 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> work = new LinkedList<>();
        work.add(root);
        Set<Node> visited = new HashSet<>();
        while (!work.isEmpty()) {
            Node peek = work.peek();
            if (peek.children.size() == 0 || visited.contains(peek)) {
                work.pop();
                res.add(peek.val);
                continue;
            }
            for (int i = peek.children.size() - 1; i >= 0; i--) {
                work.push(peek.children.get(i));
            }
            visited.add(peek);
        }
        return res;
    }


    public List<Integer> postorderWithRecursion(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        doPostorder(root, res);
        return res;
    }

    private void doPostorder(Node root, List<Integer> res) {
        if (root.children != null) {
            for (Node child : root.children) {
                doPostorder(child, res);
            }
        }
        res.add(root.val);
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
