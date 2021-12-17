package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        doCombinationSum2(res, candidates, target, cur, 0);
        return res;
    }


    private void doCombinationSum2(List<List<Integer>> res, int[] candidates, int target, List<Integer> cur, int preIdx) {
        for (int i = preIdx; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > preIdx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur.add(candidates[i]);
            if (candidates[i] == target) {
                res.add(new ArrayList<>(cur));
            } else {
                doCombinationSum2(res, candidates, target - candidates[i], cur, i + 1);
            }
            cur.remove(cur.size() - 1);
        }
    }
}
