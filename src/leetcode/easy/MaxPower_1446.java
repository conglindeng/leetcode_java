package leetcode.easy;

public class MaxPower_1446 {
    public int maxPower(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 1;
        int curCount = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curCount++;
            } else {
                res = Math.max(res, curCount);
                curCount = 1;
            }
        }
        res = Math.max(res, curCount);
        return res;
    }
}
