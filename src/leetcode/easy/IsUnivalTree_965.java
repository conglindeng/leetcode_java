package leetcode.easy;

import struct.TreeNode;

/**
 * @ClassName IsUnivalTree_965
 * @Description TODO
 * @Author conglindeng
 * @Date 2022/5/24 12:16
 * @Version 1.0
 */
public class IsUnivalTree_965 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (root.left != null) {
            if (root.left.val != val) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.right.val != val) {
                return false;
            }
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
