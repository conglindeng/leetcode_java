package leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph_133 {
    Map<Integer, Node> cache = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node res = new Node(node.val);
        cache.put(node.val, res);
        for (Node neighbor : node.neighbors) {
            if (cache.get(neighbor.val) == null) {
                cache.put(neighbor.val, cloneGraph(neighbor));
            }
            res.neighbors.add(cache.get(neighbor.val));
        }
        return res;
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
