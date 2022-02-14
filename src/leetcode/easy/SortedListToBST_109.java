package leetcode.easy;

import struct.ListNode;
import struct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedListToBST_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> items = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            items.add(cur.val);
            cur = cur.next;
        }
        int[] nums = new int[items.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = items.get(i);
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
