package leetcode.middle;

import struct.ListNode;

public class ReverseBetween_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead=new ListNode(-1,head);
        ListNode cur=newHead;
        int index=0;
        ListNode leftOldNode=null;
        ListNode leftNode=null;
        ListNode reverseNodeHead=new ListNode();
        while(cur.next!=null){
            index++;
            if(index>=left && index<=right){
                insertNodeAfterHead(reverseNodeHead,cur.next.val);
                if(index==left){
                    leftOldNode=cur;
                    leftNode=reverseNodeHead.next;
                }
                if(index==right){
                    cur=cur.next;
                    break;
                }
            }
            cur=cur.next;
        }
        leftOldNode.next=reverseNodeHead.next;
        if(cur.next!=null){
            leftNode.next=cur.next;
        }

        return newHead.next;
    }

    private ListNode insertNodeAfterHead(ListNode head,int val){
        if(head.next==null){
            head.next=new ListNode(val);
            return head;
        }
        ListNode nextNode=head.next;
        head.next=new ListNode(val);
        head.next.next=nextNode;
        return head;
    }





    public ListNode reverseBetween_2(ListNode head, int left, int right) {
        ListNode newHead=new ListNode(-1,head);
        int index=0;
        ListNode leftNode=null;
        ListNode cur=newHead;
        while(cur.next!=null){
            index++;
            if(index>=left && index<=right){
                if(index==left){
                    leftNode=cur;
                    continue;
                }
                if(index==right){
                    break;
                }


            }
            cur=cur.next;
        }
        return head;
    }

    private void insertNodeAfterLeftAndUpdateRight(ListNode left,ListNode cur){
        ListNode next = left.next;

    }
}




