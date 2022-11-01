package leetcode.difficult;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Skiplist_120 {


    Node root;

    Random random;


    public Skiplist_120() {
        root = new Node(-1);
        random = new Random();
    }

    public boolean search(int target) {
        Node temp = root;
        while (temp != null) {
            if (temp.val == target) {
                return true;
            } else if (temp.right != null && temp.right.val > target) {
                temp = temp.right;
            } else {
                temp = temp.down;
            }
        }
        return false;
    }

    public void add(int num) {
        if (search(num)) {
            //do none op when exist
            return;
        }
        //every linked list level`s latest node
        Deque<Node> work = new LinkedList<>();
        Node temp = root;
        //find insert position at first
        while (true) {
            if (temp.right != null && temp.right.val < num) {
                temp = temp.right;
            } else if (temp.down == null) {
                work.addLast(temp);
                break;
            } else {
                work.addLast(temp);
                temp = temp.down;
            }

        }
        //insert node on the bottom Node linked list
        Node newNode = new Node(num);
        newNode.right = temp.right;
        temp.right = newNode;

        //build index
        while (!work.isEmpty()) {
            //fifty 2 fifty
            if (random.nextBoolean()) {
                Node pre;
                if (work.size() == 1) {
                    work.pollLast();
                    pre = new Node(-1);
                    pre.down = root;
                    root = pre;
                } else {
                    //只有一个
                    pre = work.pollLast();
                }
                Node n = new Node(num);
                n.down = newNode;

                n.right = pre.right;
                pre.right = n;

                newNode = n;
            } else {
                break;
            }
        }
    }

    // effect as well as delete
    public boolean erase(int num) {
        if (!search(num)) {
            return false;
        }
        //how to do with head node
        Node pre = root;
        Node cur;
        while (pre != null) {
            cur = pre.right;
            if (cur == null) {
                pre = pre.down;
                continue;
            }
            if (cur.val == num) {
                pre.right = cur.right;
                pre = pre.down;
            } else if (cur.val > num) {
                pre = pre.right;
            } else {
                break;
            }
        }
        return true;
    }


    static class Node {

        Node right;
        Node down;
        int val;


        public Node(int val) {
            this.val = val;
        }
    }


}