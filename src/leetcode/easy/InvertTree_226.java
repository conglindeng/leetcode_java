package leetcode.easy;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree_226 {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;

        dfs(left);
        dfs(right);
    }


    public TreeNode invertTree_otherWay(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> work = new LinkedList<>();
        work.offer(root);
        while (!work.isEmpty()) {
            TreeNode poll = work.poll();
            if (poll == null) {
                continue;
            }
            TreeNode left = poll.left;
            TreeNode right = poll.right;
            poll.left = right;
            poll.right = left;
            work.offer(left);
            work.offer(right);
        }
        return root;
    }
}
