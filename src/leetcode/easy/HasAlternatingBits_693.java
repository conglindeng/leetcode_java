package leetcode.easy;

public class HasAlternatingBits_693 {
    public boolean hasAlternatingBits(int n) {
        int m = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                m = i;
            }
        }
        int second = n & 1;
        int first = -1;
        for (int i = 1; i <= m; i++) {
            first = second;
            second = (n >> i) & 1;
            if ((first ^ second) != 1) {
                return false;
            }
        }
        return true;
    }
}
