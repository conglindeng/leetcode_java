package leetcode.middle;

import struct.ListNode;

public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = getMidNode(head);
        ListNode second = midNode.next;
        midNode.next = null;
        return mergeListNode(sortList(head), sortList(second));
    }

    private ListNode getMidNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode mergeListNode(ListNode first, ListNode second) {
        ListNode mockHead = new ListNode(-1);
        ListNode pre = mockHead;
        ListNode cur1 = first;
        ListNode cur2 = second;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        if (cur1 != null) {
            pre.next = cur1;
        }
        if (cur2 != null) {
            pre.next = cur2;
        }
        return mockHead.next;
    }
}
