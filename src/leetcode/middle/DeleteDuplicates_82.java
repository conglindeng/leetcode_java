package leetcode.middle;

import struct.ListNode;

public class DeleteDuplicates_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode mockHead=new ListNode(-1,head);
        ListNode cur = head;
        ListNode pre = mockHead;
        ListNode next = null;
        boolean repeated = false;

        while (cur.next != null) {
            next = cur.next;
            if (next.val == cur.val) {
                deleteCurOrNextNode(cur, next);
                repeated = true;
            } else if (repeated) {
                deleteCurOrNextNode(pre, cur);
                cur=pre.next;
                repeated = false;
            } else {
                pre = cur;
                cur = next;
                next = null;
            }
        }
        if(repeated){
            pre.next=null;
        }
        return mockHead.next;
    }

    private void deleteCurOrNextNode(ListNode pre, ListNode curOrNext) {
        if(curOrNext.next==null){
            pre.next=null;
        }else{
            pre.next=curOrNext.next;
        }
    }

//    private void deleteCurAndNextNode(ListNode pre, ListNode cur, ListNode next) {
//
//    }
}
