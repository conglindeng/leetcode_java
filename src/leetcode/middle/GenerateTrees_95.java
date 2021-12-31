package leetcode.middle;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class GenerateTrees_95 {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lTrees = generateTrees(start, i - 1);
            List<TreeNode> rTress = generateTrees(i + 1, end);
            for (TreeNode lTree : lTrees) {
                for (TreeNode rTree : rTress) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = lTree;
                    treeNode.right = rTree;
                    res.add(treeNode);
                }
            }
        }
        return res;
    }
}
