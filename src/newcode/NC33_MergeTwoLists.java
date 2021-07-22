package newcode;

import struct.ListNode;

public class NC33_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mockHead = new ListNode(-1);
        ListNode pre = mockHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null & cur2 != null) {
            if (cur1.val < cur2.val) {
                pre.next = cur1;
                pre = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                pre = cur2;
                cur2 = cur2.next;
            }
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
