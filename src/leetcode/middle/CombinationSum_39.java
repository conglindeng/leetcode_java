package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
     *
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        doCombinationSum(res, candidates, target, 0, cur);
        return res;
    }

    private void doCombinationSum(List<List<Integer>> res, int[] candidates, int target, int preIdx, List<Integer> cur) {
        for (int i = preIdx; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            cur.add(candidates[i]);
            if (candidates[i] == target) {
                res.add(new ArrayList<>(cur));
            }else{
                doCombinationSum(res, candidates, target - candidates[i], i, cur);
            }
            cur.remove(cur.size() - 1);
        }
    }

}
