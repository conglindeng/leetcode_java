package newcode;

import struct.TreeNode;

import java.util.*;

public class NC60_JudgeIt {
    public boolean[] judgeIt(TreeNode root) {
        // write code here
        boolean[] res = new boolean[2];
        res[0] = isSearchTree(root);
        res[1] = isCompleteTree(root);
        return res;
    }

    /**
     * 判断是否是搜索二叉树
     *
     * @param root 根节点
     * @return true or false
     */
    private boolean isSearchTree(TreeNode root) {
        //中序遍历，put进集合时，判断是否是升序
        Integer pre = null;
        TreeNode cur = root;
        Deque<TreeNode> work = new LinkedList<>();
        while (cur != null || !work.isEmpty()) {
            if (cur != null) {
                work.push(cur);
                cur = cur.left;
            } else {
                TreeNode poll = work.poll();
                if (pre == null) {
                    pre = poll.val;
                } else {
                    if (pre > poll.val) {
                        return false;
                    } else {
                        pre = poll.val;
                    }
                }
                cur = poll.right;
            }
        }
        return true;
    }

    /**
     * 判断是否是
     *
     * @param root 根节点
     * @return true or false
     */
    private boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> work = new LinkedList<>();
        work.add(root);
        while (true) {
            TreeNode poll = work.poll();
            if (poll == null) {
                break;
            }
            work.add(poll.left);
            work.add(poll.right);
        }
        while (!work.isEmpty()) {
            if (work.poll() != null) {
                return false;
            }
        }
        return true;
    }
}
