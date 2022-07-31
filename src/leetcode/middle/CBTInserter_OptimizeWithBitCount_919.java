package leetcode.middle;

import java.util.LinkedList;
import java.util.Queue;
import struct.TreeNode;

class CBTInserter_OptimizeWithBitCount_919 {

    TreeNode root;
    int count;

    public CBTInserter_OptimizeWithBitCount_919(TreeNode root) {
        this.root = root;
        Queue<TreeNode> work = new LinkedList<>();
        work.offer(root);
        while (!work.isEmpty()) {
            count++;
            TreeNode poll = work.poll();
            if (poll.left != null) {
                work.offer(poll.left);
            }
            if (poll.right != null) {
                work.offer(poll.right);
            }
        }

    }

    public int insert(int val) {
        TreeNode newNode = new TreeNode(val);
        //todo : dcl
        return -1;
    }

    public TreeNode get_root() {
        return root;
    }
}