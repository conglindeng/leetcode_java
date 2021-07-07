package newcode;

import struct.ListNode;

public class NC53_RemoveNthFromEnd {
    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if(head==null)
            return null;
        ListNode mockHead=new ListNode(-1,head);
        ListNode pre=mockHead;
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<n;i++){
            if(fast==null) {
                return null;
            }
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            pre=slow;
            slow=slow.next;
        }
        pre.next=slow.next;
        return mockHead.next;
    }
}
