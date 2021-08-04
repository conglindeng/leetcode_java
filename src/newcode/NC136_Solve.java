package newcode;

import struct.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NC136_Solve {


    /**
     * 输入：   [1,2,4,5,3],[4,2,5,1,3]
     * 返回值： [1,3,5]
     *
     * @param xianxu
     * @param zhongxu
     * @return
     */
    public int[] solve(int[] xianxu, int[] zhongxu) {
        // write code here
        TreeNode root = buildTree(xianxu, zhongxu, 0, xianxu.length - 1, 0, zhongxu.length - 1);
        return  getRightView(root);
    }


    private TreeNode buildTree(int[] pre, int[] mid, int begin, int end, int left, int right) {
        if (begin <= end) {
            int i = pre[begin];
            int index = getIndex(mid, i);
            int length = index - left;
            TreeNode res = new TreeNode(i);
            res.left = buildTree(pre, mid, begin + 1, begin + length, left, left + length);
            res.right = buildTree(pre, mid, begin + length + 1, end, left + length + 1, right);
            return res;
        }
        return null;
    }


    private int getIndex(int[] mid, int target) {
        for (int i = 0; i < mid.length; i++) {
            if (mid[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private int[] getRightView(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> work = new LinkedList<>();
        work.add(root);
        List<Integer> temp = new ArrayList<>();
        while (!work.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            while (!work.isEmpty()) {
                TreeNode pop = work.pop();
                if (work.isEmpty()) {
                    temp.add(pop.val);
                }
                if (pop.left != null) {
                    nextLevel.add(pop.left);
                }
                if (pop.right != null) {
                    nextLevel.add(pop.right);
                }
            }
            work.addAll(nextLevel);
        }
        int[] res=new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i]=temp.get(i);
        }
        return res;
    }

}
