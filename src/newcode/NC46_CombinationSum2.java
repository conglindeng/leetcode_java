package newcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class NC46_CombinationSum2 {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    /**
     * 输入：
     * [100,10,20,70,60,10,50],80
     * 返回值：
     * [[10,10,60],[10,20,50],[10,70],[20,60]]
     * 说明：
     * 给定的候选数集是[100,10,20,70,60,10,50]，目标数是80
     */
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        if (num == null || num.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(num);
        ArrayList<Integer> curCol = new ArrayList<>();
        bfs(num, num.length, 0, target, curCol);
        return res;
    }


    private void bfs(int[] num, int length, int curIndex, int target, ArrayList<Integer> curCol) {
        if (curIndex > length - 1) {
            return;
        }
        for (int i = curIndex; i < length; i++) {
            if (i > curIndex && num[i] == num[i - 1]) {
                continue;
            }
            curCol.add(num[i]);
            if (num[i] == target) {
                res.add(new ArrayList<>(curCol));
            } else {
                bfs(num, length, i + 1, target - num[i], curCol);
            }
            curCol.remove(curCol.size() - 1);
        }

    }
}
