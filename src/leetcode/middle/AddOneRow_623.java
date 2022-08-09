package leetcode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import struct.TreeNode;

public class AddOneRow_623 {

    int val;
    int depth;

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        this.depth = depth;
        this.val = val;
        return dfs(root, 1);
    }

    private TreeNode dfs(TreeNode root, int curDepth) {
        if (curDepth == depth - 1) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else if (curDepth < depth) {
            if (root.left != null) {
                dfs(root.left, curDepth + 1);
            }
            if (root.right != null) {
                dfs(root.right, curDepth + 1);
            }
        }
        return root;
    }


    public TreeNode addOneRow_dfs_Optimize(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }
        if (depth == 1) {
            root = new TreeNode(val, root, null);
        } else if (depth == 2) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        } else {
            root.left = addOneRow_dfs_Optimize(root.left, val, depth - 1);
            root.right = addOneRow_dfs_Optimize(root.right, val, depth - 1);
        }
        return root;
    }

    public TreeNode addOneRow_bfs_Optimize(TreeNode root, int val, int depth) {
        TreeNode mockTree = new TreeNode(-1, root, null);
        Queue<TreeNode> work = new LinkedList<>();
        work.add(mockTree);
        int level = 0;
        while (!work.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            while (!work.isEmpty()) {
                TreeNode poll = work.poll();
                if (level == depth - 1) {
                    poll.left = new TreeNode(val, poll.left, null);
                    poll.right = new TreeNode(val, null, poll.right);
                } else {
                    if (poll.left != null) {
                        temp.add(poll.left);
                    }
                    if (poll.right != null) {
                        temp.add(poll.right);
                    }
                }
            }
            ++level;
            work.addAll(temp);
        }
        return mockTree.left;
    }

}
