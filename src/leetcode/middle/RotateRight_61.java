package leetcode.middle;

import struct.ListNode;

public class RotateRight_61 {
    public ListNode rotateRight(ListNode head,int k){
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur=head;
        int size=1;
        while(cur.next!=null){
            cur=cur.next;
            size++;
        }
        int m=k%size;
        ListNode mockHead=new ListNode(-1,head);
        for(int i=0;i<m;i++){
            doRotateRight(mockHead);
        }
        return mockHead.next;
    }

    private void doRotateRight(ListNode head){
        ListNode cur=head;
        ListNode next=head.next;
        while(next.next!=null){
            cur=cur.next;
            next=cur.next;
        }
        cur.next=null;
        next.next=head.next;
        head.next=next;
    }
}
