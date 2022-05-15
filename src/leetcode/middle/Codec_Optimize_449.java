package leetcode.middle;

import struct.TreeNode;

public class Codec_Optimize_449 {

    //搜索树  对于序列化有什么有利的特性？
    //中序 + 先序
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        DLR(root, sb);
        String dlr = sb.deleteCharAt(sb.length() - 1).toString();
        StringBuilder m = new StringBuilder();
        LDR(root, m);
        String ldr = m.deleteCharAt(m.length() - 1).toString();
        return dlr + ";" + ldr;
    }


    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] split = data.split(";");
        String[] dlr = split[0].split(" ");
        String[] ldr = split[1].split(" ");
        return buildTreeByLDRAndDLR(ldr, 0, ldr.length - 1, dlr, 0, dlr.length - 1);
    }

    private TreeNode buildTreeByLDRAndDLR(String[] ldr, int left, int right, String[] dlr, int begin, int end) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(Integer.parseInt(ldr[left]));
        }
        String val = dlr[begin];
        TreeNode res = new TreeNode(Integer.parseInt(val));
        int valIdx = getValIdx(ldr, val, left, right);
        int l = valIdx - left;
        res.left = buildTreeByLDRAndDLR(ldr, left, valIdx - 1, dlr, begin + 1, begin + l);
        res.right = buildTreeByLDRAndDLR(ldr, valIdx + 1, right, dlr, begin + l + 1, end);
        return res;
    }

    private int getValIdx(String[] ldr, String val, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (ldr[i].equals(val)) {
                return i;
            }
        }
        return -1;
    }


    private void DLR(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        sb.append(' ');
        DLR(root.left, sb);
        DLR(root.right, sb);
    }

    private void LDR(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        LDR(root.left, sb);
        sb.append(root.val);
        sb.append(' ');
        LDR(root.right, sb);
    }
}