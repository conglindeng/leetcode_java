package newcode;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NC81_KthNode {
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 0) {
            return null;
        }
        List<TreeNode> ldr = LDR(pRoot);
        if (ldr.size() < k) {
            return null;
        }
        return ldr.get(k);
    }

    private List<TreeNode> LDR(TreeNode pRoot) {
        List<TreeNode> res = new ArrayList<>();
        Deque<TreeNode> work = new LinkedList<>();
        TreeNode cur = pRoot;
        while (!work.isEmpty() || cur != null) {
            if (cur != null) {
                work.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = work.pop();
                res.add(pop);
                cur = pop.right;
            }
        }
        return res;
    }
}
