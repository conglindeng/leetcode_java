package newcode;

import struct.ListNode;

public class NC25_DeleteDuplicates {

    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            while (cur != null && cur.val == pre.val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
            if(cur!=null){
                cur = cur.next;
            }
        }

        return head;
    }
}
