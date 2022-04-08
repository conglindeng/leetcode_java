package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> work = new LinkedList<>();
        work.offer(root);
        while (!work.isEmpty()) {
            List<Node> nextLevel = new ArrayList<>();
            List<Integer> curVals = new ArrayList<>();
            while (!work.isEmpty()) {
                Node poll = work.poll();
                nextLevel.addAll(poll.children);
                curVals.add(poll.val);
            }
            res.add(curVals);
            work.addAll(nextLevel);
        }
        return res;
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
