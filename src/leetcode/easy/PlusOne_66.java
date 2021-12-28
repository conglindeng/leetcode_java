package leetcode.easy;

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int p = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int cur = digits[i] + p;
            digits[i] = cur % 10;
            p = cur / 10;
        }
        if (p != 0) {
            int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = p;
            return res;
        } else {
            return digits;
        }
    }
}
