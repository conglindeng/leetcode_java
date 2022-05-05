package leetcode.middle;


import struct.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheWinner_1823 {
    public int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1;
        }
        if (k == 1) {
            return n;
        }
        //如果k=1，则直接返回n
        ListNode last = new ListNode(n);
        ListNode next = last;
        for (int i = n - 1; i >= 1; i--) {
            next = new ListNode(i, next);
        }
        last.next = next;

        int size = n;
        //从1开始
        ListNode cur = next;
        for (; size > 1; ) {
            ListNode nextRemovePreItem = findNextRemovePreItem(k, cur);
            nextRemovePreItem.next = nextRemovePreItem.next.next;
            cur = nextRemovePreItem.next;
            size--;
        }
        return cur.val;
    }


    private ListNode findNextRemovePreItem(int k, ListNode cur) {
        ListNode temp = cur;
        int count = 1;
        while (count < k - 1) {
            temp = temp.next;
            count++;
        }
        return temp;
    }


    public int findTheWinner_Optimize(int n, int k) {
        Queue<Integer> work = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            work.offer(i);
        }
        while (work.size() > 1) {
            for (int i = 0; i < k; i++) {
                work.offer(work.poll());
            }
            work.poll();
        }
        return work.peek();
    }

}
