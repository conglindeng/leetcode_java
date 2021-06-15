package leetcode.easy;

import struct.ListNode;
import struct.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GetIntersectionNode_160 {
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA==null||headB==null)
            return null;
        int lengthA=0;
        int lengthB=0;
        ListNode curA=headA;
        ListNode curB=headB;
        while(curA.next!=null){
            lengthA++;
            curA=curA.next;
        }
        while(curB.next!=null){
            lengthB++;
            curB=curB.next;
        }
        if(curA!=curB){
            return null;
        }
        curA=headA;
        curB=headB;
        if(lengthA>lengthB){
            for(int i=0;i<lengthA-lengthB;i++){
                curA=curA.next;
            }
        }else{
            for(int i=0;i<lengthB-lengthA;i++){
                curB=curB.next;
            }
        }
        while(curA!=null && curB!=null){
            if(curA==curB){
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode_Set(ListNode headA,ListNode headB){
        Set<ListNode> s=new HashSet<>();
        ListNode curA=headA;
        ListNode curB=headB;
        while(curA!=null){
            s.add(curA);
            curA=curA.next;
        }
        while(curB!=null){
            if(s.contains(curB)){
                return curB;
            }
            curB=curB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode_TwoPointer(ListNode headA,ListNode headB){
        if (headA == null || headB == null)
            return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }

}
