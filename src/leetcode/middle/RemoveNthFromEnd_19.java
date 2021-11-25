package leetcode.middle;

import struct.ListNode;

public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode mockHead = new ListNode();
        mockHead.next = head;
        ListNode fast = head;
        ListNode low = mockHead;
        while (n-- > 0) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        while (fast != null) {
            low = low.next;
            fast = fast.next;
        }
        low.next = low.next.next;
        return mockHead.next;
    }
}
