package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class Combine_77 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> cur = new ArrayList<>();
        doCombine(cur, 1, n, k);
        return res;
    }

    private void doCombine(List<Integer> cur, int idx, int n, int length) {
        if (cur.size() == length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i <= n; i++) {
            cur.add(i);
            doCombine(cur, i + 1, n, length);
            cur.remove(cur.size() - 1);
        }
    }
}
