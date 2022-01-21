package leetcode.middle;

import struct.TreeNode;

public class BuildTree_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return doBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode doBuildTree(int[] inorder, int left, int right, int[] postordere, int begin, int end) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(inorder[left], null, null);
        }
        int index = getIndex(inorder, postordere[end]);
        int rightSize = right - index;
        TreeNode cur = new TreeNode(postordere[end]);
        cur.left = doBuildTree(inorder, left, index - 1, postordere, begin, end - rightSize - 1);
        cur.right = doBuildTree(inorder, index + 1, right, postordere, end - rightSize, end - 1);
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
