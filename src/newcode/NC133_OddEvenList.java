package newcode;

import struct.ListNode;

public class NC133_OddEvenList {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList (ListNode head) {
        // write code here

        if(head==null||head.next==null){
            return head;
        }
        ListNode mockHead=new ListNode(-1);
        mockHead.next=head;
        ListNode oddCur=head;
        ListNode evenCur=head.next;
        ListNode cur=evenCur.next;
        evenCur.next=null;
        int count=1;
        while(cur!=null){
            ListNode next=cur.next;
            if(count%2==0){
                cur.next=evenCur.next;
                evenCur.next=cur;
                evenCur=cur;
            }else{
                cur.next=oddCur.next;
                oddCur.next=cur;
                oddCur=cur;
            }
            count++;
            cur=next;
        }
        return mockHead.next;
    }
}
