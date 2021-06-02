package leetcode.middle;

import struct.ListNode;

public class SplitListToParts_725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode head=root;
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        int m=count/k;
        int n=count%k;
        ListNode[] result=new ListNode[k];
        ListNode cur=root;
        if(m==0){
            int index=0;
            while(cur!=null){
                result[index++]=cur;
                ListNode next = cur.next;
                cur.next=null;
                cur=next;
            }
            return result;
        }
        for (int i = 0; i < k; i++) {
            if(cur==null)
                break;
            result[i]=cur;
            for (int j = 0; j < m-1 && cur!=null; j++) {
                cur=cur.next;
            }
            if(n>0 && cur!=null){
                cur=cur.next;
                n--;
            }
            ListNode next = cur.next;
            cur.next=null;
            cur=next;
        }
        return result;
    }
}
