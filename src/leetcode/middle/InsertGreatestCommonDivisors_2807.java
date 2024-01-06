package leetcode.middle;

import struct.ListNode;

public class InsertGreatestCommonDivisors_2807 {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            int n = findMaxCommonDivisor(cur.val, next.val);
            ListNode node = new ListNode(n);
            cur.next = node;
            node.next = next;
            cur = next;
        }
        return head;
    }

    private int findMaxCommonDivisor(int m, int n) {
        if (n > m) {
            int temp = m;
            m = n;
            n = temp;
        }
        for (int i = n; i >= 1; i--) {
            if (m % i == 0 && n % i == 0) {
                return i;
            }
        }
        return 1;
    }


    private int findMaxCommonDivisor_optimize(int m, int n) {
        while (n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }
}
