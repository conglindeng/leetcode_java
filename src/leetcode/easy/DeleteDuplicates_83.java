package leetcode.easy;

import struct.ListNode;

public class DeleteDuplicates_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        //ListNode mockHead=new ListNode(-1,head);
        ListNode cur = head;
        ListNode next = null;

        while (cur.next != null) {
            next = cur.next;
            if (next.val == cur.val) {
                deleteCurOrNextNode(cur, next);
            }  else {
                cur = next;
                next = null;
            }
        }
        return head;
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
