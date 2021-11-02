package leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermuteUnique_47 {

    boolean[] flag;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] arr) {
        Arrays.sort(arr);
        flag = new boolean[arr.length];
        List<Integer> cur = new ArrayList<>();
        bfs(arr, cur);
        return res;
    }


    private void bfs(int[] arr, List<Integer> cur) {
        if (cur.size() == arr.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (flag[i] || (i > 0 && arr[i] == arr[i - 1] && !flag[i - 1])) {
                continue;
            }
            cur.add(arr[i]);
            flag[i] = true;
            bfs(arr, cur);
            flag[i] = false;
            if (cur.size() > 0)
                cur.remove(cur.size() - 1);
        }
    }

}
