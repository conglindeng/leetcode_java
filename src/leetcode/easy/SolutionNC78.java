package leetcode.easy;

/**
 * @Description 输入一个链表，反转链表后，输出新链表的表头。
 * @Author 邓兴亮
 * @Date 2021/3/31 11:23
 */
public class SolutionNC78 {
public static class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override public String toString() {
        return "ListNode{" + "val=" + val + ", next=" + next + '}';
    }
}

    /**
     * @param head
     * @return {@link ListNode}
     * @author 邓兴亮
     * @date 2021/4/1 10:12
     **/
    public static ListNode ReverseList(ListNode head) {
        // 判断链表为空或长度为1的情况
        if(head == null || head.next == null){
            return head;
        }
        // 当前节点的前一个节点
        ListNode pre = null;
        // 当前节点的下一个节点
        ListNode next = null;
        while( head != null){
            // 记录当前节点的下一个节点位置；
            next = head.next;
            // 让当前节点指向前一个节点位置，完成反转
            head.next = pre;
            // pre 往右走
            pre = head;
            // 当前节点往右继续走
            head = next;
        }
        return pre;
    }


    public static ListNode ReverseList_1(ListNode head) {
        // 判断链表为空或长度为1的情况
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);

        ListNode cur=head;
        ListNode next;
        while( cur != null){
            next=cur.next;

            cur.next= newHead.next;
            newHead.next=cur;

            cur=next;
        }
        return newHead.next;
    }



    public static void main(String[] args) {
        ListNode testListNode = new ListNode(1);
        testListNode.next = new ListNode(2);
        testListNode.next.next = new ListNode(3);
        ListNode listNode = ReverseList_1(testListNode);
        System.out.println(listNode);
    }
}
