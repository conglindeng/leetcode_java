package leetcode.difficult;

import struct.ListNode;

public class ReverseKGroup_25 {
    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。
     * <p>
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 进阶：
     * <p>
     * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode cursor = head;
        int count = 0;
        while (cursor != null) {
            count++;
            cursor = cursor.next;
        }
        int maxCount = (count / k) * k;
        ListNode mockHead = new ListNode();
        mockHead.next = head;
        //用于指向翻转后的头
        ListNode pre = mockHead;
        //用于翻转后的尾指向下一个node
        cursor = head;

        while (maxCount != 0) {

            //在遍历时不断将当前元素插入到头节点之前
            //翻转后的起点，用于插入节点到真正的头节点和临时头之间
            ListNode tempHead = new ListNode();
            //翻转k个node
            ListNode first = cursor;
            for (int i = 0; i < k; i++) {
                //先把下一个节点保存下
                ListNode next = cursor.next;

                //将当前节点插入到翻转链表头节点处
                cursor.next = tempHead.next;
                tempHead.next = cursor;

                //再将遍历节点指向原next
                cursor = next;
            }
            //更改这一段的前后指向关系，并更新下一个循环需要的pre
            pre.next = tempHead.next;
            pre = first;
            first.next = cursor;
            maxCount -= k;
        }
        return mockHead.next;
    }
}
