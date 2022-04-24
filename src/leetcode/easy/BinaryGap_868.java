package leetcode.easy;

public class BinaryGap_868 {
    public int binaryGap(int n) {
        int res = 0;
        int pre = -1;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                if (pre != -1) {
                    res = Math.max(i - pre, res);
                }
                pre = i;
            }
        }
        return res;
    }
}
