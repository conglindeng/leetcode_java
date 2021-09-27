package newcode;

import java.util.ArrayList;
import java.util.Arrays;

public class NC43_Permute {
    /**
     * 给出一组数字，返回该组数字的所有排列
     * 例如：
     * [1,2,3]的所有排列如下
     * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
     * （以数字在数组中的位置靠前为优先级，按字典序排列输出。）
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        //是否取过的标识数组，取过为1，未取过为0
        int[] flag = new int[num.length];
        backTrack(num, flag, res, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] num, int[] flag, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur) {
        if (cur.size() == num.length) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < num.length; i++) {
            if (flag[i] == 0) {
                cur.add(num[i]);
                flag[i] = 1;
                backTrack(num, flag, res, cur);
                flag[i] = 0;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
