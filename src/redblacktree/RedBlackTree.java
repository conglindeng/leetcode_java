package redblacktree;

import java.util.Deque;
import java.util.LinkedList;

public class RedBlackTree {
    RedBlackNode root;

    public void intsert(int key, int val) {
        //1.如果root为null，说明可以直接插入
        if (root == null) {
            root = new RedBlackNode(key, val, null, null, false);
        }
        //找到应该插入的位置，为了处理变色的情况，还需要保存访问的路径，father、gradfather等
        RedBlackNode node = search(key);
        if (node != null) {
            node.val = val;
            return;
        }
        RedBlackNode cur = root;
        Deque<RedBlackNode> work = new LinkedList<>();
        while (cur != null) {
            if (cur.key < key) {
                work.push(cur);
                cur = cur.right;
            } else {
                work.push(cur);
                cur = cur.left;
            }
        }
        //work 中至少有一个root元素
        //2.如果父亲是黑色，则直接插入即可。
        RedBlackNode father = work.poll();
        if (!father.isRed) {
            if (father.key > key) {
                father.left = new RedBlackNode(key, val);
            } else {
                father.right = new RedBlackNode(key, val);
            }
            return;
        }



    }

    public void delete(int key) {

    }

    public RedBlackNode search(int key) {
        RedBlackNode cur = root;
        while (cur != null) {
            if (cur.key == key) {
                return cur;
            } else if (cur.key < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return null;
    }

}
