import linkedlist.TwoPointer;
import struct.ListNode;

public class ListNodeMain {
    public static void main(String[] args) {
        ListNode head= new ListNode(1,new ListNode(1,new ListNode(3,new ListNode(3,new ListNode(5)))));

        //new ReverseBetween_92().reverseBetween(head,2,4);
        //new DeleteDuplicates_82().deleteDuplicates(head);

        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        ListNode node7=new ListNode(7);
        ListNode node8=new ListNode(8);
        ListNode node9=new ListNode(9);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
//
//        node4.next=node5;
//        node5.next=node6;
//        node6.next=node7;
//        node7.next=node8;
//        node8.next=node9;


        //region make a intersect
/*        ListNode node10=new ListNode(10);
        ListNode node11=new ListNode(11);
        ListNode node12=new ListNode(12);
        node10.next=node11;
        node11.next=node12;
        node12.next=node6;
        System.out.println(TwoPointer.findIntersectingNode_2(node1, node10).val);*/
        //endregion

        System.out.println(TwoPointer.removeNthFromEnd(node1, 4));
        //ListNode head= new ListNode(1,new ListNode(1,null));
    }
}
