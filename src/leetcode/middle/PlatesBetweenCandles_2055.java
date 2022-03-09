package leetcode.middle;

public class PlatesBetweenCandles_2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (query[1] - query[0] < 3) {
                res[i] = 0;
            }
            int left = query[0], right = query[0];
            int curRes = 0;
            while (left <= query[1]) {
                while (right <= query[1] && s.charAt(right) == '*') {
                    right++;
                }
                if (right > query[1]) {
                    break;
                }
                if (left != query[0]) {
                    curRes += right - left;
                }
                left = right + 1;
                right = left;
            }
            res[i] = curRes;
        }

        return res;
    }

    public int[] platesBetweenCandles_Optimize(String s, int[][] queries) {
        int l = s.length();
        int[] prefix = new int[l];
        for (int i = 0, sum = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            prefix[i] = sum;

        }
        int[] left = new int[l];
        int idx = -1;
        int i = 0;
        while (i < l) {
            if (s.charAt(i) == '|') {
                idx = i;
            }
            left[i] = idx;
            i++;
        }
        int[] right = new int[l];
        idx = -1;
        i = l - 1;
        while (i >= 0) {
            if (s.charAt(i) == '|') {
                idx = i;
            }
            right[i] = idx;
            i--;
        }
        int[] res = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int[] query = queries[j];
            if (query[1] - query[0] < 2) {
                res[j] = 0;
            } else {
                int m = left[query[1]];
                int n = right[query[0]];
                if (m != -1 && n != -1 && m < n) {
                    res[j] = prefix[n] - prefix[m];
                }
            }
        }
        return res;
    }
}
