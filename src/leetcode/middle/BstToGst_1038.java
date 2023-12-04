package leetcode.middle;

import java.util.ArrayList;
import java.util.List;
import struct.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
 * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left =
 * left; this.right = right; } }
 */
public class BstToGst_1038 {

    List<Integer> vals;
    int[] sum;
    int i;

    public TreeNode bstToGst(TreeNode root) {
        vals = new ArrayList<>();
        ldr(root, false);
        sum = new int[vals.size()];
        for (int i = vals.size() - 1; i >= 0; i--) {
            if (i == vals.size() - 1) {
                sum[i] = vals.get(i);
            } else {
                sum[i] = vals.get(i) + sum[i + 1];
            }
        }
        ldr(root, true);
        return root;
    }


    public void ldr(TreeNode node, boolean repalce) {
        if (node == null) {
            return;
        }
        ldr(node.left, repalce);
        if (repalce) {
            node.val = sum[i++];
        } else {
            vals.add(node.val);

        }
        ldr(node.right, repalce);
    }

}
