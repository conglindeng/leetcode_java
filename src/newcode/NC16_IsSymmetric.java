package newcode;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NC16_IsSymmetric {
    /**
     * 判断树是否是对称的
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isSymmetric(TreeNode root) {
        // write code here

        if (root == null) {
            return true;
        }
        return comPareTree(root.left, root.right);
    }

    private boolean comPareTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean leftAndRight = comPareTree(left.left, right.right);
        boolean rightAndleft = comPareTree(left.right, right.left);
        return leftAndRight && rightAndleft;
    }

    public boolean isSymmetricByQueue(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> work = new LinkedList<>();
        work.add(root.left);
        work.add(root.right);
        while (!work.isEmpty()) {
            TreeNode left = work.poll();
            TreeNode right = null;
            if (!work.isEmpty()) {
                right = work.poll();
            }
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            work.add(left.left);
            work.add(right.right);
            work.add(left.right);
            work.add(right.left);
        }
        return true;
    }


}
