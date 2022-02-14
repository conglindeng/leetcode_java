package leetcode.middle;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();

        bfs(root, cur, res, targetSum);
        return res;
    }

    private void bfs(TreeNode root, List<Integer> cur, List<List<Integer>> res, int targetSum) {
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                cur.add(root.val);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        cur.add(root.val);
        if (root.left != null) {
            bfs(root.left, cur, res, targetSum - root.val);
        }
        if (root.right != null) {
            bfs(root.right, cur, res, targetSum - root.val);
        }
        cur.remove(cur.size() - 1);
    }
}
