package leetcode.easy;

import struct.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindTarget_653 {
    Set<Integer> ints = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (ints.contains(k - root.val)) {
            return true;
        }
        ints.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
