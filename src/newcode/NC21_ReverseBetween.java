package newcode;

import struct.ListNode;

public class NC21_ReverseBetween {
    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        if (m == n || m > n) {
            return head;
        }
        ListNode mockHead = new ListNode(-1);
        mockHead.next = head;
        ListNode pre = mockHead;
        ListNode start = null;
        ListNode cur = head;
        int count = 1;
        while (cur != null) {
            if (count == m) {
                start = cur;
                count++;
                cur = cur.next;
                while (cur != null && count <= n) {
                    ListNode next = cur.next;
                    cur.next = pre.next;
                    pre.next = cur;
                    cur = next;
                    count++;
                }
                start.next = cur;
                break;
            }
            pre = cur;
            cur = cur.next;
            count++;
        }
        return mockHead.next;
    }
}
