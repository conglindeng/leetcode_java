package leetcode.middle;

import java.util.LinkedList;
import java.util.Queue;
import struct.TreeNode;

class CBTInserter_919 {

    TreeNode root;

    public CBTInserter_919(TreeNode root) {
        this.root = root;
    }

    public int insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return -1;
        } else {
            Queue<TreeNode> work = new LinkedList<>();
            work.offer(root);
            while (!work.isEmpty()) {
                TreeNode poll = work.poll();
                if (poll.left == null) {
                    poll.left = new TreeNode(val);
                    return poll.val;
                }
                if (poll.right == null) {
                    poll.right = new TreeNode(val);
                    return poll.val;
                }
                work.offer(poll.left);
                work.offer(poll.right);
            }
        }
        return -1;
    }

    public TreeNode get_root() {
        return root;
    }
}