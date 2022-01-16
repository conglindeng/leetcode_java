package leetcode.middle;

import struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RecoverTree_99 {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> vals = new LinkedList<>();
        List<TreeNode> nodes = new LinkedList<>();
        Deque<TreeNode> work = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !work.isEmpty()) {
            if (cur != null) {
                work.push(cur);
                cur = cur.left;
            } else {
                TreeNode poll = work.poll();
                vals.add(poll.val);
                nodes.add(poll);
                cur = poll.right;
            }
        }
        int change = -1;
        int min = -1;
        int minIdx = -1;
        for (int i = 1; i < vals.size(); i++) {
            if (vals.get(i) < vals.get(i - 1) && change == -1) {
                change = i - 1;
                min = vals.get(i);
                minIdx = i;
            }
            if (change != -1) {
                if (min > vals.get(i)) {
                    min = vals.get(i);
                    minIdx = i;
                }
            }
        }
        nodes.get(minIdx).val = nodes.get(change).val;
        nodes.get(change).val = min;
    }


    public void recoverTree_Optimize(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> work = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode change = null;
        TreeNode min = null;
        while (cur != null || !work.isEmpty()) {
            if (cur != null) {
                work.push(cur);
                cur = cur.left;
            } else {
                TreeNode poll = work.poll();
                if (pre != null) {
                    if (change == null) {
                        if (pre.val > poll.val) {
                            change = pre;
                            min = poll;
                        }
                    } else {
                        if (min.val > poll.val) {
                            min = poll;
                        }
                    }
                }
                pre = poll;
                cur = poll.right;
            }
        }
        int temp = min.val;
        min.val = change.val;
        change.val = temp;
    }

}
