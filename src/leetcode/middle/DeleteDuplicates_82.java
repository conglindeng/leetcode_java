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

    public ListNode deleteDuplicates_new(ListNode head) {
        ListNode mockedHead = new ListNode(-200, head);
        ListNode cur = mockedHead;
        while (true) {
            ListNode next = cur.next;
            if (next == null) {
                break;
            }
            boolean equal = false;
            while (next.next != null && next.val == next.next.val) {
                equal = true;
                next = next.next;
            }
            if (equal) {
                cur.next = next.next;
            } else {
                cur = next;
            }
        }
        return mockedHead.next;
    }
}
