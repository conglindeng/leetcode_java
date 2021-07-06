package newcode;

import struct.ListNode;

public class NC24_DeleteDuplicates {
    /**
     * 给出的链表为1→2→3→3→4→4→5, 返回1→2→5.
     * 给出的链表为1→1→1→2→3, 返回2→3.
     *
     * 此解法重发的元素留下了一个
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // write code here
        ListNode mockHead = new ListNode(-1);
        ListNode pre = mockHead;
        pre.next = head;
        ListNode cur = head;
        int curValue = -1;
        while (cur != null) {
            while (cur.val == curValue) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
            curValue = pre.val;
            cur = cur.next;
        }
        return mockHead.next;
    }

    public ListNode deleteDuplicates_optimize(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mockNode=new ListNode(-1);
        mockNode.next=head;
        ListNode pre=mockNode;
        ListNode start=head;
        ListNode end=head.next;
        while(end!=null){
            boolean flag=false;
            while(end!=null && end.val==start.val){
                flag=true;
                end=end.next;
            }
            if(flag){
                pre.next=end;
                if(end!=null){
                    start=end;
                    end=end.next;
                }
            }else{
                pre=start;
                start=end;
                end=end.next;
            }
        }
        return mockNode.next;
    }
}
