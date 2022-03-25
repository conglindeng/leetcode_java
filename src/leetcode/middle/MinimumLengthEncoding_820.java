package leetcode.middle;

import java.util.*;

public class MinimumLengthEncoding_820 {
    public int minimumLengthEncoding(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                wordSet.remove(word.substring(i));
            }
        }
        int res = 0;
        for (String s : wordSet) {
            res += s.length() + 1;
        }
        return res;
    }


    public int minimumLengthEncoding_Optimize(String[] words) {
        TreeNode root = new TreeNode();
        Map<TreeNode, Integer> idxMap = new HashMap<>();
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            TreeNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int idx = word.charAt(i) - 'a';
                TreeNode temp = cur.childrens[idx];
                if (temp == null) {
                    temp = new TreeNode();
                    cur.childrens[idx] = temp;
                }
                cur.count++;
                cur = temp;
            }
            idxMap.put(cur, j);
        }
        int res = 0;
        for (TreeNode treeNode : idxMap.keySet()) {
            //为0说明为叶子节点，是需要添加的有效的字符串
            if (treeNode.count == 0) {
                res += words[idxMap.get(treeNode)].length() + 1;
            }
        }
        return res;
    }

    private static class TreeNode {
        TreeNode[] childrens;
        int count;

        public TreeNode() {
            this.childrens = new TreeNode[26];
            count = 0;
        }
    }
}
