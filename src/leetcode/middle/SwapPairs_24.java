package leetcode.middle;

import struct.ListNode;

public class SwapPairs_24 {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        //需要2个变量，pre，first
        // first和first.next是不要交换的两个node，前提是first.next不为空
        // pre的next指向first，用于改变前后关系
        ListNode mockHead = new ListNode();
        mockHead.next = head;
        ListNode pre = mockHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next == null) {
                //当前只有一个，推出循环
                break;
            }
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;


            pre = cur;
            cur = pre.next;
        }
        return mockHead.next;
    }
}
