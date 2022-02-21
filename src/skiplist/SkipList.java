package skiplist;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class SkipList {

    SkipNode head;

    //最大的索引层数
    private static final int IDX_MAX_LEVEL = 4;

    private static final Random random = new Random();

    public SkipList() {
        this.head = new SkipNode(Integer.MIN_VALUE, -1);
    }

    public SkipNode search(int key) {
        SkipNode temp = head;
        while (temp != null) {
            if (temp.key == key) {
                return temp;
            } else if (temp.right == null) {
                temp = temp.down;
            } else if (temp.right.key > key) {
                temp = temp.down;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }

    public void delete(int key) {
        SkipNode temp = head;
        while (temp != null) {
            if (temp.right == null) {
                temp = temp.down;
            } else if (temp.right.key == key) {
                temp.right = temp.right.right;
                temp = temp.down;
            } else if (temp.right.key > key) {
                temp = temp.down;
            } else {
                temp = temp.right;
            }
        }
    }


    public void insert(int key, int value) {
        // 先查找一下是否已经有了对应的key，如有则更新对应值
        SkipNode node = this.search(key);
        if (node != null) {
            node.val = value;
            return;
        }
        //保存每次down时的节点，用于生成索引（前置节点）
        Deque<SkipNode> stack = new LinkedList<>();
        SkipNode temp = head;
        while (temp != null) {
            if (temp.right == null) {
                stack.push(temp);
                temp = temp.down;
            } else if (temp.right.key > key) {
                stack.push(temp);
                temp = temp.down;
            } else {
                temp = temp.right;
            }
        }
        int curLevel = 1;
        SkipNode down = null;
        while (true) {
            SkipNode poll = stack.poll();
            if (curLevel == 1) {
                down = extracted(key, value, poll, down);
            } else if (curLevel <= IDX_MAX_LEVEL) {
                int i = random.nextInt(10);
                if (i < 5) {
                    down = extracted(key, value, poll, down);
                } else {
                    return;
                }
            } else {
                return;
            }
            curLevel++;
        }
    }

    private SkipNode extracted(int key, int value, SkipNode poll, SkipNode down) {
        SkipNode pre = new SkipNode(key, value);
        if (poll == null) {
            poll = new SkipNode(Integer.MIN_VALUE, -1);
            poll.down = this.head;
            this.head = poll;
        }
        pre.right = poll.right;
        poll.right = pre;
        pre.down = down;
        return pre;
    }

    public void printList() {
        SkipNode teamNode = head;
        int index = 1;
        SkipNode last = teamNode;
        while (last.down != null) {
            last = last.down;
        }
        while (teamNode != null) {
            SkipNode enumNode = teamNode.right;
            SkipNode enumLast = last.right;
            System.out.printf("%-8s", "head->");
            while (enumLast != null && enumNode != null) {
                if (enumLast.key == enumNode.key) {
                    System.out.printf("%-5s", enumLast.key + "->");
                    enumLast = enumLast.right;
                    enumNode = enumNode.right;
                } else {
                    enumLast = enumLast.right;
                    System.out.printf("%-5s", "");
                }

            }
            teamNode = teamNode.down;
            index++;
            System.out.println();
        }
    }
}
