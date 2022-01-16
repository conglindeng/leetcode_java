package leetcode.middle;

import struct.ListNode;

import java.util.Random;

public class Solution_Optimize_382 {
    ListNode head;
    Random random;

    public Solution_Optimize_382(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int i = 1;
        ListNode cur = head;
        int ans = -1;
        while (cur != null) {
            int nextInt = random.nextInt(i);
            if (nextInt == 0) {
                ans = cur.val;
            }
            i++;
            cur = cur.next;
        }
        return ans;
    }
}
