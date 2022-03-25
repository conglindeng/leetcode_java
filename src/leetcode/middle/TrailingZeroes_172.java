package leetcode.middle;

public class TrailingZeroes_172 {
    // 数学题：求 [1,n]中所有的2和5的因数个数，
    // 2必然比5多（神奇的证明）
    // 所以求5因数的个数即可
    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int j = i; j % 5 == 0; j /= 5) {
                res++;
            }
        }
        return res;
    }
}
