package linkedlist;

import struct.ListNode;

public class TwoPointer {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (slowPointer != null && fastPointer != null) {
            slowPointer = slowPointer.next;
            if (fastPointer.next == null) {
                return false;
            }
            fastPointer = fastPointer.next.next;

            if (slowPointer.val == fastPointer.val) {
                return true;
            }
        }
        return false;
    }

    public static ListNode findIntersectingNode(ListNode first, ListNode second) {
        ListNode curFirst = first;
        ListNode curSecond = second;
        int length1 = 1;
        int length2 = 1;
        while (curFirst.next != null) {
            length1++;
            curFirst = curFirst.next;
        }
        while (curSecond.next != null) {
            length2++;
            curSecond = curSecond.next;
        }
        int length = length1 + length2;
        int length11 = 0;
        int length22 = 0;
        curFirst = first;
        curSecond = second;
        while (length11 <= length && length22 <= length) {
            if (curFirst.val == curSecond.val) {
                return curFirst;
            }
            if (length11 == length1) {
                curFirst = second;
            } else {
                curFirst = curFirst.next;
            }
            length11++;
            if (length22 == length2) {
                curSecond = first;
            } else {
                curSecond = curSecond.next;
            }
            length22++;
        }
        return new ListNode(-1);
    }

    public static ListNode findIntersectingNode_2(ListNode first, ListNode second) {
        ListNode curFirst = first;
        ListNode curSecond = second;
        int length1 = 1;
        int length2 = 1;
        while (curFirst.next != null) {
            length1++;
            curFirst = curFirst.next;
        }
        while (curSecond.next != null) {
            length2++;
            curSecond = curSecond.next;
        }
        curFirst = second;
        curSecond = first;
        if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) {
                curSecond = curSecond.next;
            }
        } else {
            for (int i = 0; i < length2 - length1; i++) {
                curFirst = curFirst.next;
            }
        }
        while (curFirst != null && curSecond != null) {
            if (curFirst.val == curSecond.val) {
                return curFirst;
            }
            curFirst = curFirst.next;
            curSecond = curSecond.next;
        }
        return new ListNode(-1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1) {
            return head;
        }
        ListNode virtualHead=new ListNode(-1,head);
        ListNode fast = virtualHead;
        ListNode low = virtualHead;
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return virtualHead.next;
            }
            fast = fast.next;
        }
        while (fast.next!=null) {
            low=low.next;
            fast=fast.next;
        }
        low.next= low.next.next;
        return virtualHead.next;
    }


    public static ListNode mergeTwoLinkedList(ListNode first,ListNode second){

        ListNode curFirst=first;
        ListNode curSecond=second;
        while(curFirst!=null&&curSecond!=null){



        }

        return null;
    }

}
