package leetcode.middle;

import java.util.ArrayList;
import java.util.List;

public class GoodDaysToRobBank_2100 {
    /**
     * 时间不符合要求 时间复杂度：(n-2time)*time*2
     *
     * @param security
     * @param time
     * @return
     */
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        ArrayList<Integer> res = new ArrayList<>();
        if (security == null || security.length == 0) {
            return res;
        }
        //寻找凹点
        if (time == 0) {
            for (int i = 0; i < security.length; i++) {
                res.add(i);
            }
            return res;
        }
        if (time * 2 >= security.length) {
            return res;
        }
        for (int i = time; i <= security.length - 1 - time; i++) {
            boolean flag = true;
            for (int j = i - time; j < i; j++) {
                if (security[j] < security[j + 1]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                continue;
            }
            for (int j = i; j < i + time; j++) {
                if (security[j] > security[j + 1]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                continue;
            }
            res.add(i);
        }
        return res;
    }

    public List<Integer> goodDaysToRobBank_OptimizeWithPrefix(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        int l = security.length;
        int[] g = new int[l];
        for (int i = 1; i < l; i++) {
            if (security[i - 1] == security[i]) {
                continue;
            }
            g[i] = security[i - 1] > security[i] ? 1 : -1;
        }
        //表示递增的前缀和
        int[] a = new int[l + 1];
        //表示递减的前缀和
        int[] b = new int[l + 1];
        for (int i = 1; i <= l; i++) {
            a[i] = a[i - 1] + (g[i - 1] == -1 ? 1 : 0);
            b[i] = b[i - 1] + (g[i - 1] == 1 ? 1 : 0);
        }
        for (int i = time; i <= l - time - 1; i++) {
            //要求i左侧递减，即不能递增，更具体的则时a[i+1]与a[i-time+1]的差为0
            int m = a[i - time + 1] - a[i + 1];
            //要求i右侧递增，即不能递减，b[i+time+1]与b[i+1]的差为0
            int n = b[i + time + 1] - b[i + 1];
            if (m == 0 && n == 0) {
                res.add(i);
            }
        }
        return res;
    }


    public List<Integer> goodDaysToRobBank_OptimizeWithDp(int[] security, int time) {
        int l = security.length;
        int[] left = new int[l];
        int[] right = new int[l];
        for (int i = 1; i < l; i++) {
            if (security[i - 1] >= security[i]) {
                left[i] = left[i - 1] + 1;
            }
            if (security[l - i] >= security[l - i - 1]) {
                right[l - i - 1] = right[l - i] + 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = time; i < l - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }

}
