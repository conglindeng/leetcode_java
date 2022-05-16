package leetcode.middle;

import java.util.Deque;
import java.util.LinkedList;
import struct.TreeNode;

/**
 * @ClassName InorderSuccessor_04_06
 * @Description TODO
 * @Author conglindeng
 * @Date 2022/5/16 12:16
 * @Version 1.0
 */
public class InorderSuccessor_04_06 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        Deque<TreeNode> work = new LinkedList<>();
        TreeNode temp = root;
        boolean find = false;
        while (!work.isEmpty() || temp != null) {
            if (temp != null) {
                work.push(temp);
                temp = temp.left;
            } else {
                temp = work.poll();
                if (find) {
                    return temp;
                }
                if (p == temp) {
                    find = true;
                }
                temp = temp.right;
            }
        }
        return null;
    }

    public TreeNode inorderSuccessor_Optimize(TreeNode root, TreeNode p) {
        TreeNode res = null;
        if (p.right != null) {
            TreeNode temp = p.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val > p.val) {
                res = temp;
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return res;
    }

}
