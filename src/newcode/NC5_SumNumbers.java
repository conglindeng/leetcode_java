package newcode;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NC5_SumNumbers {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        searchLeafs(root, sb);
        return sum;
    }

    public void searchLeafs(TreeNode root, StringBuilder str) {
        str.append(root.val);
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(str.toString());
        }
        if (root.left != null) {
            searchLeafs(root.left, str);
        }
        if (root.right != null) {
            searchLeafs(root.right, str);
        }
        str.deleteCharAt(str.length()-1);
    }
}
