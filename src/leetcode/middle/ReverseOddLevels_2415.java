package leetcode.middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import struct.TreeNode;

public class ReverseOddLevels_2415 {

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> work = new LinkedList<>();
        work.add(root);
        int level = 0;
        while (work.size() > 0) {
            List<TreeNode> next = new ArrayList<>();
            while (work.size() > 0) {
                TreeNode treeNode = work.pollFirst();
                if (treeNode.left != null) {
                    next.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    next.add(treeNode.right);
                }
            }
            level++;
            if ((level & 1) == 1) {
                int left = 0;
                int right = next.size() - 1;
                while (left < right) {
                    TreeNode leftNode = next.get(left);
                    TreeNode rightNode = next.get(right);
                    int temp = leftNode.val;
                    leftNode.val = rightNode.val;
                    rightNode.val = temp;
                    left++;
                    right--;
                }

            }
            work.addAll(next);

        }
        return root;
    }

}
