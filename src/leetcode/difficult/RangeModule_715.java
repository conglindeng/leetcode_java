package leetcode.difficult;

public class RangeModule_715 {

    //区间的有序链表
    Node head;

    public RangeModule_715() {
        head = null;
    }

    public void addRange(int left, int right) {
        if (head == null) {
            head = new Node(left, right);
        } else {
            Node temp = head;
            //对于已经存在的各个区间，新插入的区间与已存在的区间可能的关系是：
            //左右端点需要注意，左包含，右不包含
            //1。某个已存在区间内-不做处理
            //2。包含于多个区间内-区间合并
            Node l = null, r = null;
            while (temp != null) {
                if (temp.right >= left) {
                    l = temp;
                }
                if (judge(right, temp)) {
                    r = temp;
                }
                temp = temp.next;
            }
            // [14.20) add [11,23]
            if (l == r) {
                l.left = Math.min(left, l.left);
                l.right = Math.max(l.right, right);
            } else {
                l.left = Math.min(left, l.left);
                r.right = Math.max(r.right, right);
                l.next = r;
            }
        }
    }

    private boolean judge(int val, Node temp) {
        return (temp.left <= val && temp.right > val)
            ||
            (temp.right <= val && (temp.next == null || temp.next.left > val));
    }

    public boolean queryRange(int left, int right) {
        return false;
    }

    public void removeRange(int left, int right) {

    }

    static class Node {

        //表示[left,right) 左闭右开的数字区间
        private int left;
        private int right;
        private Node next;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}