package leetcode.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import struct.TreeNode;

public class PseudoPalindromicPaths_1457 {

    private int res = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        iterateTree(root, new HashMap<>());
        return res;
    }

    private void iterateTree(TreeNode root, Map<Integer, Integer> numCount) {
        numCount.put(root.val, numCount.getOrDefault(root.val, 0) + 1);
        if (root.left == null && root.right == null) {
            //judge
            int allCount = 0;
            int oddCount = 0;
            for (Entry<Integer, Integer> entry : numCount.entrySet()) {
                if (entry.getValue() > 0) {
                    allCount += entry.getValue();
                    if (entry.getValue() % 2 != 0) {
                        oddCount++;
                    }
                }
            }
            if (allCount % 2 == 0 && oddCount == 0) {
                res++;
            } else if (allCount % 2 == 1 && oddCount == 1) {
                res++;
            }
        }
        if (root.left != null) {
            iterateTree(root.left, numCount);
        }
        if (root.right != null) {
            iterateTree(root.right, numCount);
        }
        numCount.put(root.val, numCount.get(root.val) - 1);
    }
}
