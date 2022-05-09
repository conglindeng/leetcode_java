package leetcode.easy;

public class DiStringMatch_942 {
    /**
     * 贪心策略
     *
     * @param s
     * @return
     */
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        int n = s.length();
        int m = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                res[i] = n--;
            } else {
                res[i] = m++;
            }
        }
        res[s.length()] = m;
        return res;
    }
}
