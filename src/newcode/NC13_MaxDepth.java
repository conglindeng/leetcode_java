package newcode;

import struct.TreeNode;

public class NC13_MaxDepth {
    public int maxDepth(TreeNode root) {
        // write code here
        return getMaxHeight(root, 0);
    }

    private int getMaxHeight(TreeNode root, int height) {
        if (root == null) {
            return height;
        }
        return Math.max(getMaxHeight(root.left,height+1),getMaxHeight(root.right,height+1));
    }
}
