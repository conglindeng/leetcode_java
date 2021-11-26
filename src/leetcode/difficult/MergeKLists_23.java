package leetcode.difficult;

import struct.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeKLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        //朴素的遍历的当前每一个ListNode头，找最小的那个
        // 若某一个ListNode遍历到结尾了，就不管了
        ListNode res = new ListNode();
        ListNode resCursor = res;
        List<ListNode> cursor = new ArrayList<>();
        for (ListNode list : lists) {
            if(list!=null){
                cursor.add(list);
            }
        }
        while (!cursor.isEmpty()) {
            if (cursor.size() == 1) {
                resCursor.next = cursor.get(0);
                break;
            }
            ListNode listNode = cursor.stream().min(Comparator.comparingInt(x -> x.val)).get();
            cursor.remove(listNode);
            ListNode next = listNode.next;
            resCursor.next = listNode;
            listNode.next = null;
            if (next != null) {
                cursor.add(next);
            }
            resCursor = resCursor.next;
        }

        return res.next;
    }
}
