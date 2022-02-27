package leetcode.middle;

import struct.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class ReorderList_143 {
    public void reorderList(ListNode head) {
        //使用栈来保存顺序，交换顺序的时候，栈弹出即可。
        //另需要一个count变量，用于判定是否交换结束，即遍历至count/2时结束
        Deque<ListNode> work = new LinkedList<>();
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            work.push(cur);
            ++count;
            cur = cur.next;
        }
        int i = 0;
        cur = head;
        while (i < (count - 1) / 2) {
            //先把下一节点保存下来
            ListNode next = cur.next;
            ListNode poll = work.poll();
            poll.next = next;
            cur.next = poll;
            cur = next;
            i++;
        }
        work.peek().next = null;
    }

    // 链表中间节点查找+反转链表+合并链表
    public void reorderList_Optimize(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode midNode = findMidNode(head);
        ListNode second = reverseListNode(midNode.next);
        midNode.next = null;
        mergeListNode(head, second);
    }

    private ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseListNode(ListNode head) {
        ListNode mockHead = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = mockHead.next;
            mockHead.next = cur;
            cur = next;
        }
        return mockHead.next;
    }

    private void mergeListNode(ListNode first, ListNode second) {
        ListNode cur1 = first;
        ListNode cur2 = second;
        while (cur1 != null && cur2 != null) {
            ListNode next1 = cur1.next;
            ListNode next2 = cur2.next;
            cur2.next = cur1.next;
            cur1.next = cur2;
            cur1 = next1;
            cur2 = next2;
        }
    }
}
