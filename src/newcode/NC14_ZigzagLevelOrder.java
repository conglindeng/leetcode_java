package newcode;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class NC14_ZigzagLevelOrder {
    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write code here
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> work = new LinkedList<>();
        work.add(root);
        int level = 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (!work.isEmpty()) {
            ArrayList<TreeNode> nextLevel = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            while (!work.isEmpty()) {
                TreeNode poll = work.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    nextLevel.add(poll.left);
                }
                if (poll.right != null) {
                    nextLevel.add(poll.right);
                }
            }
            if (level % 2 == 0) {
                res.add(list);
            }else{
                Collections.reverse(list);
                res.add(list);
            }
            level++;
            work.addAll(nextLevel);
        }
        return res;
    }
}
