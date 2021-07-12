package newcode;

import struct.ListNode;
import util.StringUtils;

import java.util.Deque;
import java.util.LinkedList;

public class NC96_IsPail {
    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail(ListNode head) {
        // write code here

        if (head == null)
            return false;
        int length = 0;
        ListNode cur = head;
        Deque<Integer> work=new LinkedList<>();
        while (cur != null) {
            length++;
            work.push(cur.val);
            cur = cur.next;
        }
        cur=head;
        for(int i=0;i<length/2;i++){
            if(work.poll()!=cur.val){
                return false;
            }
            cur=cur.next;
        }
        return true;

    }
}
