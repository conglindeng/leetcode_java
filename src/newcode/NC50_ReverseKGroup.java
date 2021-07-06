package newcode;

import struct.ListNode;

public class NC50_ReverseKGroup {

    /**
     * 给定的链表是1→2→3→4→5
     * 对于 k = 2 k=2, 你应该返回  2→1→4→3→5
     * 对于 k = 3 k=3, 你应该返回  3→2→1→4→5
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        int size=0;
        ListNode cur = head;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        if(size<k){
            return head;
        }
        int end= size/k*k;
        // write code here
        int index = 0;
        ListNode mockHead = new ListNode(-1);
        cur = head;
        ListNode pre = mockHead;
        ListNode start = null;
        ListNode next = null;
        while (cur != null && index<end) {
            next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            if (index % k == 0) {
                //表示开启新的一轮，记录start
                start = cur;
            }
            if (index % k == k - 1) {
                //表示将开启新的一轮
                pre = start;
            }
            cur = next;
            index++;
        }
        if(cur!=null)
            pre.next=cur;
        return mockHead.next;
    }


}
