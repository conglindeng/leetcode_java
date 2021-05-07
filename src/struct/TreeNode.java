package struct;

import sun.reflect.generics.tree.Tree;

import java.util.List;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    public List<TreeNode> nodes;

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public TreeNode(int val, List<TreeNode> nodes) {
        this.val = val;
        this.nodes = nodes;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
