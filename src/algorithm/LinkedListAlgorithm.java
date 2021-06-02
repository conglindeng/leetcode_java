package algorithm;

import struct.ListNode;

public class LinkedListAlgorithm {
    public static boolean hasCircle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(slow!=null&&fast!=null){
            if(slow.val==fast.val){
                return true;
            }
            if(fast.next==null){
                break;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return false;
    }
}
