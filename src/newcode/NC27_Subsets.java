package newcode;

import java.util.ArrayList;
import java.util.Arrays;

public class NC27_Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (S == null || S.length == 0) {
            return res;
        }
        Arrays.sort(S);
        int length = S.length;
        int size = 1 << length;
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> item = new ArrayList<>();
            int m = i;
            for (int value : S) {
                if ((m & 1) == 1) {
                    item.add(value);
                }
                m >>= 1;
            }
            res.add(item);
        }
        res.sort((a, b) -> {
            if (a.size() == b.size()) {
                for (int i = 0; i < a.size(); i++) {
                    if (a.get(i) < b.get(i)) {
                        return -1;
                    }
                }
            } else {
                return a.size() - b.size();
            }
            return 0;
        });
        return res;
    }


    public ArrayList<ArrayList<Integer>> subsets_Optimize(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (S == null || S.length == 0) {
            return res;
        }
        Arrays.sort(S);
        int length = S.length;
        for (int i = 0; i <= length; i++) {
            backTrack(S, 0, i, res, new ArrayList<>());
        }
        return res;
    }

    private void backTrack(int[] S, int index, int count, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur) {
        if (count == cur.size()) {
            res.add(new ArrayList<>(cur));
        }
        if (index >= S.length) {
            return;
        }
        for (int i = index; i < S.length; i++) {
            cur.add(S[i]);
            backTrack(S, i + 1, count, res, cur);
            cur.remove(cur.size() - 1);
        }
    }

}
