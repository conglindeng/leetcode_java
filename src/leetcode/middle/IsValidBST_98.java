package leetcode.middle;

import struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidBST_98 {
    private static class Info {
        boolean valid;
        int max;
        int min;

        public Info(boolean valid, int max, int min) {
            this.valid = valid;
            this.max = max;
            this.min = min;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return validTree(root).valid;
    }

    private Info validTree(TreeNode node) {
        int val = node.val;
        if (node.left == null && node.right == null) {
            return new Info(true, val, val);
        }
        int min = val;
        Info infoLeft = null;
        if (node.left != null) {
            infoLeft = validTree(node.left);
            min = infoLeft.min;
        }
        int max = val;
        Info infoRight = null;
        if (node.right != null) {
            infoRight = validTree(node.right);
            max = infoRight.max;
        }
        if (infoRight != null && (!infoRight.valid || infoRight.min <= val)) {
            return new Info(false, val, val);
        }
        if (infoLeft != null && (!infoLeft.valid || infoLeft.max >= val)) {
            return new Info(false, val, val);
        }
        //此时当前树是符合要求的，需要更新max和min
        return new Info(true, max, min);
    }


    public boolean isValidBST_LDR(TreeNode root) {
        Deque<TreeNode> work = new LinkedList<>();
        TreeNode cur = root;
        double pre = -Double.MAX_VALUE;
        while (cur != null || !work.isEmpty()) {
            if (cur != null) {
                work.push(cur);
                cur = cur.left;
            } else {
                TreeNode poll = work.pop();
                if (pre >= poll.val) {
                    return false;
                }
                pre = poll.val;
                cur = poll.right;
            }
        }
        return true;
    }
}
