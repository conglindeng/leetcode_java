package leetcode.easy;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        bfs(new StringBuilder(), root);
        return res;
    }

    private void bfs(StringBuilder sb, TreeNode root) {
        int l = sb.length();
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            sb.delete(l, sb.length());
            return;
        }
        sb.append(root.val);
        sb.append("->");
        if (root.left != null) {
            bfs(sb, root.left);
        }
        if (root.right != null) {
            bfs(sb, root.right);
        }
        sb.delete(l, sb.length());
    }
}
