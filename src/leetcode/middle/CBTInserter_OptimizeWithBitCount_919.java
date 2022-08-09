package leetcode.middle;

import java.util.LinkedList;
import java.util.Queue;
import struct.TreeNode;

public class CBTInserter_OptimizeWithBitCount_919 {

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
        count++;
        int i = 31 - Integer.numberOfLeadingZeros(count);
        TreeNode temp = root;
        for (int j = i - 1; j > 0; j--) {
            if (((count >> j) & 1) == 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if ((count & 1) == 1) {
            temp.right = newNode;
        } else {
            temp.left = newNode;
        }
        return temp.val;
    }

    public TreeNode get_root() {
        return root;
    }
}