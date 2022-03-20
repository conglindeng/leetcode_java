package leetcode.easy;

import struct.TreeNode;

import java.util.*;

public class Tree2str_606 {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        Deque<TreeNode> work = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        work.push(root);
        StringBuilder res = new StringBuilder();
        while (!work.isEmpty()) {
            TreeNode pop = work.pop();
            if (visited.contains(pop)) {
                res.append(")");
            } else {
                res.append("(");
                res.append(pop.val);
                work.push(pop);
                if (pop.left == null && pop.right != null) {
                    res.append("()");
                }
                if (pop.right != null) {
                    work.push(pop.right);
                }
                if (pop.left != null) {
                    work.push(pop.left);
                }
                visited.add(pop);
            }
        }
        return res.substring(1, res.length() - 1);
    }


    public String tree2str_(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        recusion(root, sb);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void recusion(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append("(");
        sb.append(root.val);
        if (root.right == null) {
            recusion(root.left, sb);
        } else {
            if (root.left == null) {
                sb.append("()");
            } else {
                recusion(root.left, sb);
            }
            recusion(root.right, sb);
        }
        sb.append(")");
    }
}
