package leetcode.middle;

import struct.TreeNode;

import java.util.Arrays;

public class BuildTree_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuildTre(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    private TreeNode doBuildTre(int[] preorder, int first, int second, int[] inorder, int left, int right) {
        if (first > second) {
            return null;
        }
        if (first == second) {
            return new TreeNode(preorder[first], null, null);
        }
        int val = preorder[first];
        int i = getIndex(inorder, val);
        int range = i - left;
        TreeNode cur = new TreeNode(val);
        cur.left = doBuildTre(preorder, first + 1, first + range, inorder, left, i - 1);
        cur.right = doBuildTre(preorder, first + range + 1, second, inorder, i + 1, right);
        return cur;
    }

    private int getIndex(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }


}
