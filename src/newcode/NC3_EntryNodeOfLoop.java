package newcode;

import struct.ListNode;

public class NC3_EntryNodeOfLoop {
    /**
     * 寻找链表环的入口
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null)
            return null;
        ListNode fast=pHead;
        ListNode slow=pHead;
        boolean flag=false;
        while(fast.next!=null&&slow!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                flag=true;
                break;
            }
        }
        if(!flag){
            return null;
        }
        slow=pHead;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
