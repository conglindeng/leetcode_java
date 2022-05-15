package leetcode.middle;

import java.util.ArrayList;
import java.util.List;
import struct.TreeNode;
import utils.CollectionUtils;

public class Codec_Optimize_Plus_449 {

    //搜索树  对于序列化有什么有利的特性？
    //中序 + 先序
    public String serialize(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        LDR(root, nums);
        return nums.toString();
    }


    public TreeNode deserialize(String data) {
        List<Integer> dlr = CollectionUtils.convertString2List(data, Integer::parseInt);
        List<Integer> ldr = new ArrayList<>(dlr);
        dlr.sort(Integer::compare);

        return null;
    }

    private TreeNode buildTree(List<Integer> dlr, List<Integer> ldr) {
        return null;
    }


    private void LDR(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        LDR(root.left, nums);
        nums.add(root.val);
        LDR(root.right, nums);
    }
}