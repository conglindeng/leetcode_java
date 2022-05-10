package leetcode.easy;

import struct.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class IsPalindrome_234 {

    /**
     * O(1)的空间，如何做？ 反转后半部分链表，使用快慢指针进行判定，判定完毕后再反转回去
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        ListNode slow = head;
        ListNode fast = head;
        Deque<Integer> work = new LinkedList<>();
        while (slow != null && fast != null) {
            if (fast.next == null) {
                break;
            }
            work.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (count % 2 != 0) {
            slow = slow.next;
        }
        //奇数个node指向中间的node，此时还需要往后走一步
        while (slow != null) {
             Integer poll = work.pop();
            if (slow.val != poll) {
                return false;
            }
            slow = slow.next;
        }
        return true;

    }
}
