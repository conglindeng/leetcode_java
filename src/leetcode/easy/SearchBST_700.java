package leetcode.easy;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SearchBST_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        //深度优先--先序、中序
        Deque<TreeNode> stack = new LinkedList<>();

        //中序
        TreeNode cursor = root;
        while (!stack.isEmpty() || cursor != null) {
            if (cursor != null) {
                stack.push(cursor);
                cursor = cursor.left;
            } else {
                cursor = stack.pop();
                if (cursor.val == val) {
                    return cursor;
                }
                cursor = cursor.right;
            }
        }

        //先序
        cursor = root;
        stack.push(cursor);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.val == val) {
                return pop;
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }

        //广度优先--层次遍历
        stack.push(root);
        while (!stack.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                if (pop.val == val) {
                    return pop;
                }
                if (pop.left != null) {
                    nextLevel.add(pop.left);
                }
                if (pop.right != null) {
                    nextLevel.add(pop.right);
                }
            }
            stack.addAll(nextLevel);
        }

        //二叉搜索树
        TreeNode cur = root;
        while (cur != null) {
            int val1 = cur.val;
            if (val1 == val) {
                return cur;
            } else if (val1 < val) {
                cur = cur.right;
            } else {
                cur=cur.left;
            }
        }
        return null;
    }
}
