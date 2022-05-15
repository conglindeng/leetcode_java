package leetcode.middle;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec_449 {

    //即将树转化为某个结构S，在反序列化时，根据结构S再转化为原来的形式
    // 层次遍历 -> 会超时
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //怎么确定已经到最后一个treeNode了？
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> work = new LinkedList<>();
        int count = 0;
        if (root != null) {
            count++;
        }
        work.offer(root);
        while (!work.isEmpty()) {
            TreeNode poll = work.poll();
            if (poll != null) {
                count--;
            }
            if (poll == null) {
                sb.append("#");
                work.offer(null);
                work.offer(null);
            } else {
                sb.append(poll.val);
                if (poll.left != null) {
                    count++;
                }
                if (poll.right != null) {
                    count++;
                }
                work.offer(poll.left);
                work.offer(poll.right);
            }
            sb.append(" ");
            if (count == 0) {
                break;
            }
        }
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(" ");
        TreeNode[] nodes = new TreeNode[s.length];
        for (int i = 0; i < s.length; i++) {
            if (!"#".equals(s[i])) {
                nodes[i] = new TreeNode(Integer.parseInt(s[i]));
                if (i > 0) {
                    TreeNode parent = nodes[(i - 1) / 2];
                    if (i % 2 == 0) {
                        parent.right = nodes[i];
                    } else {
                        parent.left = nodes[i];
                    }
                }
            }
        }
        return nodes[0];
    }
}