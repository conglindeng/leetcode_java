package newcode;

import struct.ListNode;

public class NC40_AddInList {
    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        ListNode cur1 = reverse(head1);
        ListNode cur2 = reverse(head2);
        ListNode result = new ListNode(-1);
        int cur = 0;
        while (cur1 != null || cur2 != null) {
            int sum = (cur1 == null ? 0 : cur1.val) + (cur2 == null ? 0 : cur2.val) + cur;
            cur = sum / 10;
            insertToHead(result, new ListNode(sum % 10));
            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;
        }
        if(cur>0){
            insertToHead(result, new ListNode(cur));
        }
        return result.next;
    }

    private void insertToHead(ListNode head, ListNode newNode) {
        newNode.next = head.next;
        head.next = newNode;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode maskHead = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = maskHead.next;
            maskHead.next = cur;

            cur = next;

        }
        return maskHead.next;
    }

}
