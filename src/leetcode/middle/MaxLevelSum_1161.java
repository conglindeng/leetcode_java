package leetcode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import struct.TreeNode;

public class MaxLevelSum_1161 {

    public int maxLevelSum(TreeNode root) {
        int res = 0;
        int maxCount = Integer.MIN_VALUE;
        Queue<TreeNode> work = new LinkedList<>();
        work.offer(root);
        int level = 1;
        while (!work.isEmpty()) {
            int curCount = 0;
            List<TreeNode> nextLevels = new ArrayList<>();
            while (!work.isEmpty()) {
                TreeNode poll = work.poll();
                curCount += poll.val;
                if (poll.left != null) {
                    nextLevels.add(poll.left);
                }
                if (poll.right != null) {
                    nextLevels.add(poll.right);
                }
            }
            if (curCount > maxCount) {
                res = level;
                maxCount = curCount;
            }
            work.addAll(nextLevels);
            ++level;
        }
        return res;
    }

    public int maxLevelSum_WithRecursion(TreeNode root) {
        //use map to save every level`s sum maybe easier to understand
        List<Integer> counts = new ArrayList<>();
        dfs(1, root, counts);
        int res = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 1; i < counts.size(); i++) {
            if (counts.get(i) > maxCount) {
                res = i;
                maxCount = counts.get(i);
            }
        }
        return res;
    }

    private void dfs(int level, TreeNode root, List<Integer> counts) {
        while (counts.size() <= level) {
            counts.add(0);
        }
        Integer integer = counts.get(level);
        counts.set(level, integer + root.val);
        if (root.left != null) {
            dfs(level + 1, root.left, counts);
        }
        if (root.right != null) {
            dfs(level + 1, root.right, counts);
        }
    }

}
