package struct;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    public List<TreeNode> nodes;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val, List<TreeNode> nodes) {
        this.val = val;
        this.nodes = nodes;
    }

    public TreeNode(int val) {
        this.val = val;
        this.nodes = new ArrayList<>();
    }
}
