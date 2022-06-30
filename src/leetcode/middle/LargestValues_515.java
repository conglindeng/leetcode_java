package leetcode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import struct.TreeNode;

public class LargestValues_515 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int h) {
        if (root == null) {
            return;
        }
        if (res.size() - 1 >= h) {
            Integer m = res.get(h);
            res.set(h, Math.max(root.val, m));
        } else {
            //说明当前层次还没遍历过
            res.add(root.val);
        }
        dfs(root.left, h + 1);
        dfs(root.right, h + 1);
    }


    public List<Integer> largestValues_WithQueue(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> work = new LinkedList<>();
        work.add(root);
        int count = 1;
        while (!work.isEmpty()) {
            int curCount = 0, curMax = Integer.MIN_VALUE;
            for (int i = 0; i < count; i++) {
                TreeNode poll = work.poll();
                curMax = Math.max(curMax, poll.val);
                if (poll.left != null) {
                    work.offer(poll.left);
                    curCount++;
                }
                if (poll.right != null) {
                    work.offer(poll.right);
                    curCount++;
                }
            }
            res.add(curMax);
            count = curCount;
        }
        return res;
    }
}
