package leetcode.middle;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GetAllElements_1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        List<Integer> l1 = LDR(root1);
        List<Integer> l2 = LDR(root2);
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) > l2.get(j)) {
                res.add(l2.get(j++));
            } else {
                res.add(l1.get(i++));
            }
        }
        while (i < l1.size()){
            res.add(l1.get(i++));
        }
        while (j < l2.size()){
            res.add(l2.get(j++));
        }
        return res;
    }

    List<Integer> LDR(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> work = new LinkedList<>();
        TreeNode temp = root;
        while (temp != null || !work.isEmpty()) {
            if (temp != null) {
                work.push(temp);
                temp = temp.left;
            } else {
                TreeNode poll = work.poll();
                res.add(poll.val);
                temp = poll.right;
            }
        }
        return res;
    }
}
