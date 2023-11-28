package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import struct.ListNode;

public class IsPalindrome_LCR027 {

    public boolean isPalindrome(ListNode head) {
        ListNode mockHead = new ListNode(-1, head);
        ListNode fast = mockHead;
        ListNode slow = mockHead;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse the second half ListNode
        ListNode reverseHead = slow.next;
        slow.next = null;
        while (reverseHead != null) {
            ListNode temp = reverseHead.next;

            reverseHead.next = slow.next;
            slow.next = reverseHead;

            reverseHead = temp;
        }

        //todo:dcl
        ListNode pre = head;
        ListNode after = slow.next;
        while (after != null) {
            if (after.val != pre.val) {
                return false;
            }
            pre = pre.next;
            after = after.next;
        }
        return true;

    }


    public boolean isPalindrome_WithArray(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            if (nums.get(left) != nums.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private ListNode head;

    public boolean isPalindrome_recursion(ListNode head) {
        this.head = head;
        return doRecursion(head);
    }

    private boolean doRecursion(ListNode cur) {
        if (cur != null) {
            if (!doRecursion(cur.next)) {
                return false;
            }
            if (head.val != cur.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

}
