package leetcode.easy;

import java.util.*;

public class Preorder_589 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        recursion(res, root);
        return res;
    }

    private void recursion(List<Integer> res, Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                recursion(res, child);
            }
        }
    }


    public List<Integer> preorderWithIterate(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> work = new LinkedList<>();
        work.push(root);
        while (!work.isEmpty()) {
            Node pop = work.pop();
            res.add(pop.val);
            for (int i = pop.children.size() - 1; i >= 0; i--) {
                work.push(pop.children.get(i));
            }
        }
        return res;
    }

    static class Node {
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
