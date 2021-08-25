package newcode;

public class NC57_Reverse {
    /**
     * 反转数字
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 你有注意到翻转后的整数可能溢出吗？因为给出的是32位整数，则其数值范围为[−2^{31}, 2^{31} − 1]。翻转可能会导致溢出，如果反转后的结果会溢出就返回 0
     *
     * @param x int整型
     * @return int整型
     */
    public int reverse(int x) {
        // write code here
        long m = x;
        if (x < 0) {
            m = Math.abs(x);
        }
        long res = 0;
        while (m != 0) {
            res = res * 10 + (m % 10);
            m = m / 10;
        }
        if (res != (int) res) {
            return 0;
        }
        return x < 0 ? -(int) res : (int) res;
    }
}
