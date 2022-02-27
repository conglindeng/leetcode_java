package leetcode.easy;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> work = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !work.isEmpty()) {
            if (cur != null) {
                res.add(cur.val);
                work.push(cur);
                cur = cur.left;
            } else {
                cur = work.poll().right;
            }
        }
        return res;
    }

    public List<Integer> midorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> work = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !work.isEmpty()) {
            if (cur != null) {
                work.push(cur);
                cur = cur.left;
            } else {
                TreeNode poll=work.poll();
                res.add(poll.val);
                cur = poll.right;
            }
        }
        return res;
    }
}
