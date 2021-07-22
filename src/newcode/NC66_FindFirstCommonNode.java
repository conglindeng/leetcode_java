package newcode;

import struct.ListNode;

public class NC66_FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while (cur1 != cur2) {
            cur1 = (cur1 == null) ? pHead2 : cur1.next;
            cur2 = (cur2 == null) ? pHead1 : cur2.next;
        }
        return cur1;
    }
}

