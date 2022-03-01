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

    public ListNode insertionSortList_Optimize(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mockHead = new ListNode();
        mockHead.next = head;
        ListNode lastSortedNode = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val >= lastSortedNode.val) {
                lastSortedNode = cur;
            } else {
                ListNode temp = mockHead;
                while (temp.next.val < cur.val) {
                    temp = temp.next;
                }
                lastSortedNode.next = next;
                cur.next = temp.next;
                temp.next = cur;
            }
            cur = next;
        }
        return mockHead.next;
    }
}
