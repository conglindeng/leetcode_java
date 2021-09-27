package newcode;

import struct.ListNode;

public class NC69_FindKthToTail {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        if (pHead == null || k < 1) {
            return null;
        }
        ListNode mockHead = new ListNode();
        mockHead.next = pHead;
        return findKth(mockHead, k);
    }


    private ListNode findKth(ListNode mockHead, int k) {
        ListNode slow = mockHead;
        ListNode fast = mockHead.next;
        while (fast != null && k > 0) {
            k--;
            fast = fast.next;
        }
        if (fast == null && k > 0) {
            return null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.next;
    }
}



