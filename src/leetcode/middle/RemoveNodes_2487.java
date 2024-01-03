package leetcode.middle;

import java.util.Deque;
import java.util.LinkedList;
import struct.ListNode;

public class RemoveNodes_2487 {

    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        head.next = removeNodes(head.next);
        if (head.next != null && head.next.val > head.val) {
            return head.next;
        } else {
            return head;
        }
    }

    public ListNode removeNodes_stack(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            stack.addLast(cur);
            cur = cur.next;
        }
        ListNode mockedHead = new ListNode();
        while (stack.size() > 0) {
            ListNode last = stack.pollLast();
            while (stack.size() > 0 && stack.peekLast().val < last.val) {
                stack.pollLast();
            }
            last.next = mockedHead.next;
            mockedHead.next = last;

        }
        return mockedHead.next;

    }
}
