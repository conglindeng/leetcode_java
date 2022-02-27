package leetcode.middle;

import struct.ListNode;

public class InsertionSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mockHead = new ListNode(-1, head);
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            doInsert(mockHead, cur);
            cur = next;
        }
        return mockHead.next;
    }

    private void doInsert(ListNode head, ListNode node) {
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null && cur.val < node.val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            node.next = pre.next;
        }
        pre.next = node;
    }
}
