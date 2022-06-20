package leetcode.middle;


public class Insert_029 {

    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node temp = head;
        while (true) {  
            if (//和当前值相等，则可以直接插入
                temp.val == insertVal
                //大于当前最大值 or 普通的两个值之间
                || (temp.val < insertVal && (temp.next.val < temp.val || temp.next.val > insertVal))
                //小于当前最小值
                || (temp.val > temp.next.val && temp.next.val > insertVal)
                //一个node
                || temp.next == temp
                //找个一圈都没找到合适的位置，说明值全部相等
                || temp.next == head) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static class Node {

        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
