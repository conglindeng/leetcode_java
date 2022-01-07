package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition_131 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        // 1.首先先求出所有的回文字符串情况，f[i][j] 表示从i到j是否是回文字符串
        //      转移方程：f[i][j]=f[i+1][j-1]&& s.charAt(i)==s.charAt(j)
        //      边界条件：f[i][j] 当i=j时，一定为true， i>j 时，一定为false (但在此次的代码中，不会出现i>j的情况，所以也将之赋值为true)
        //      遍历方向？
        //
        // 2.再从0开始做回溯遍历
        //      假设当前已经遍历到i，从0到i的数据放在了resList中
        //      则下一次遍历将从i遍历到n，如果f[i][j]=true，则将s(i,j)放入resList中。然后再进行起始点为j+1的寻找
        //      当j+1寻找完退出函数后，将s(i,j)从resList中移除
        if (s == null || s.length() == 0) {
            return res;
        }
        int length = s.length();
        boolean[][] f = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(f[i], true);
        }
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                f[i][j] = f[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        List<String> cur = new ArrayList<>();
        dfs(cur, s, 0, length, f);
        return res;
    }

    private void dfs(List<String> cur, String s, int idx, int length, boolean[][] f) {
        if (idx == length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < length; i++) {
            if (f[idx][i]) {
                cur.add(s.substring(idx, i + 1));
                dfs(cur, s, i + 1, length, f);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
