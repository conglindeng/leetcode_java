package leetcode.easy;

import struct.ListNode;

public class ReverseList_206 {

    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;

            temp.next = res;
            res = temp;

            temp = next;
        }
        return res;
    }
}
