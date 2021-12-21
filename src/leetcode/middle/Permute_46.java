package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class Permute_46 {
    boolean[] flag;
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        flag = new boolean[nums.length];
        List<Integer> cur = new ArrayList<>();
        bfs(cur, nums);
        return res;
    }

    private void bfs(List<Integer> cur, int[] nums) {
        if (nums.length == cur.size()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                cur.add(nums[i]);
                bfs(cur, nums);
                flag[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
