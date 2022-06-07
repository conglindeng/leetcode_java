package leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;
import struct.TreeNode;

/**
 * @ClassName SumRootToLeaf_1022
 * @Description TODO
 * @Author conglindeng
 * @Date 2022/5/30 09:11
 * @Version 1.0
 */
public class SumRootToLeaf_1022 {

    int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, root);
        return res;
    }

    private void dfs(StringBuilder sb, TreeNode root) {
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res += Integer.parseInt(sb.toString(), 2);
        } else {
            if (root.left != null) {
                dfs(sb, root.left);
            }
            if (root.right != null) {
                dfs(sb, root.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
    }


    public int sumRootToLeaf_Optimize(TreeNode root) {
        return lrd(root, 0);
    }

    private int lrd(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        val = (val << 1) | root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return lrd(root.left, val) + lrd(root.right, val);
    }


    public int sumRootToLeaf_Optimize_Iteration(TreeNode root) {
        int val = 0;
        int res = 0;
        Deque<TreeNode> work = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !work.isEmpty()) {
            while (cur != null) {
                val = (val << 1) | cur.val;
                work.push(cur);
                cur = cur.left;
            }
            cur = work.peek();
            if (cur.right == null || cur.right == pre) {
                if (cur.right == null && cur.left == null) {
                    res += val;
                }
                val >>= 1;
                work.poll();
                pre = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        return res;
    }


}
