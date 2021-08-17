package newcode;

import struct.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class NC2_ReorderList {


    /**
     * 输入：
     * {1,2,3,4,5}
     * 返回值：
     * {1,5,2,4,3}
     * 要求使用原地算法，不能只改变节点内部的值，需要对实际的节点进行交换。
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        int size = 0;
        ListNode cur = head;
        //栈用于从链表中间节点往前遍历到头节点
        Deque<ListNode> work = new LinkedList<>();
        while (cur != null) {
            size++;
            work.push(cur);
            cur = cur.next;
        }
        //找到中间的节点
        for (int i = 0; i < size / 2 - 1; i++) {
            work.pop();
        }
        ListNode index = work.pop();

        //把最后那个节点的next置为空
        ListNode peek = work.peek();
        peek.next = null;

        //奇数的节点则多弹出一个
        if (size % 2 != 0) {
            work.pop();
        }
        while (!work.isEmpty() && index != null) {
            ListNode next = index.next;
            ListNode poll = work.pop();
            index.next = poll.next;
            poll.next = index;
            index = next;
        }
    }
}
