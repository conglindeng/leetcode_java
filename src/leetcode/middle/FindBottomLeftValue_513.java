package leetcode.middle;

import java.util.LinkedList;
import java.util.Queue;
import struct.TreeNode;

public class FindBottomLeftValue_513 {

    TreeNode res;
    int curH = -1;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return res.val;
    }

    private void dfs(TreeNode root, int h) {
        if (root == null) {
            return;
        }
        if (h > curH) {
            res = root;
            curH = h;
        }
        dfs(root.left, h + 1);
        dfs(root.right, h + 1);
    }


    public int findBottomLeftValue_with_bfs(TreeNode root) {
        int res = 0;
        Queue<TreeNode> work = new LinkedList<>();
        work.offer(root);
        while (!work.isEmpty()) {
            TreeNode poll = work.poll();
            if (poll.right != null) {
                work.offer(poll.right);
            }
            if (poll.left != null) {
                work.offer(poll.left);
            }
            res = poll.val;
        }
        return res;
    }


}
