package leetcode.easy;

import struct.TreeNode;

public class SortedArrayToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return doTransform(nums, 0, nums.length - 1);
    }

    private TreeNode doTransform(int[] nums, int left, int right) {
        if (right - left == 0) {
            return new TreeNode(nums[left], null, null);
        }
        if (right - left == 1) {
            TreeNode cur = new TreeNode(nums[right], null, null);
            cur.left = new TreeNode(nums[left], null, null);
            return cur;
        }
        int mid = left + (right - left) / 2;
        TreeNode cur = new TreeNode(nums[mid], null, null);
        cur.left = doTransform(nums, left, mid - 1);
        cur.right = doTransform(nums, mid + 1, right);
        return cur;
    }
}
