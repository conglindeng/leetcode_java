package newcode;

import struct.ListNode;

public class NC70_SortInList {
    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        // write code here
        ListNode mockHead=new ListNode(-1);
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            ListNode pre=findPre(mockHead,cur.val);
            cur.next=pre.next;
            pre.next=cur;
            cur=next;
        }
        return mockHead.next;
    }

    private ListNode findPre(ListNode mockHead, int val) {
        ListNode pre=mockHead;
        ListNode cur=pre.next;
        while(cur!=null){
            pre=pre.next;
            cur=pre.next;
            if(cur==null||cur.val-val>0){
                break;
            }
        }
        return pre;
    }
}
