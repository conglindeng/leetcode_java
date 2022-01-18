package leetcode.middle;

import struct.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution_382 {
    List<Integer> data;

    Random random;

    public Solution_382(ListNode head) {
        ListNode cur = head;
        data = new ArrayList<>();
        while (cur != null) {
            data.add(head.val);
            cur = cur.next;
        }
        random = new Random();
    }

    public int getRandom() {
        return data.get(random.nextInt(data.size()));
    }
}
